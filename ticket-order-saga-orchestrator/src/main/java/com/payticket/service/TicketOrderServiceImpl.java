package com.payticket.service;

import com.payticket.constants.OrderStatus;
import com.payticket.dto.TicketOrderDto;
import com.payticket.entity.TicketEntity;
import com.payticket.entity.TicketOrderEntity;
import com.payticket.response.BasicResponse;
import com.payticket.response.record.TicketOrderResponse;
import com.payticket.transformer.Transformer;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.Duration;

@Service
public class TicketOrderServiceImpl implements TicketOrderService {
    @Qualifier("ticketDtoToTicketEntity")
    private final Transformer<TicketOrderDto, TicketOrderEntity> transformer;
    private final RedisTemplate<String, Object> redisTemplate;

    public TicketOrderServiceImpl(Transformer<TicketOrderDto, TicketOrderEntity> transformer, RedisTemplate<String, Object> template) {
        this.transformer = transformer;
        this.redisTemplate = template;
    }

    @Override
    public BasicResponse<TicketOrderResponse> processOrder(TicketOrderDto dto) {
        if (redisTemplate.hasKey(dto.getIdempotencyId().toString())) {
            return new BasicResponse<>(1, "IdempotencyId is present");
        }
        redisTemplate.opsForValue().set(dto.getIdempotencyId().toString(), dto.getIdempotencyId(), Duration.ofSeconds(60));
        TicketOrderEntity entity = transformer.transform(dto);
        BigDecimal amount = entity.getTicketEntitySet()
                .stream()
                .map(TicketEntity::getPrice)
                .reduce(BigDecimal.ZERO, BigDecimal::add);
        entity.setAmount(amount);
        entity.setStatus(OrderStatus.NEW);

        return new BasicResponse<>(0, "success", new TicketOrderResponse(entity.getId(), entity.getStatus()));
    }
}
