package com.payticket.transformer;

import com.payticket.dto.TicketDto;
import com.payticket.entity.TicketEntity;
import com.payticket.entity.TicketOrderEntity;
import com.payticket.dto.TicketOrderDto;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.Set;
import java.util.UUID;
import java.util.stream.Collectors;

@Component
public class TicketOrderDtoToTicketOrderEntity implements Transformer <TicketOrderDto, TicketOrderEntity> {
    @Qualifier("ticketDtoToTicketEntity")
    private final Transformer<TicketDto, TicketEntity> transformer;

    public TicketOrderDtoToTicketOrderEntity(Transformer<TicketDto, TicketEntity> transformer) {
        this.transformer = transformer;
    }

    @Override
    public TicketOrderEntity transform(TicketOrderDto dto)  {
        Set<TicketEntity> ticketEntitySet = dto.getTicketDtoSet() == null
                ? Set.of()
                : dto.getTicketDtoSet().stream()
                    .map(transformer::transform)
                    .collect(Collectors.toSet());

        return TicketOrderEntity.builder()
                .id(UUID.randomUUID().toString())
                .customerFirstName(dto.getCustomerFirstName())
                .customerLastName(dto.getCustomerLastName())
                .callbackMethod(dto.getCallbackMethod())
                .callbackUrl(dto.getCallbackUrl())
                .customerEmail(dto.getCustomerEmail())
                .currency(dto.getCurrency())
                .ticketEntitySet(ticketEntitySet)
                .createdAt(LocalDateTime.now())
                .build();
    }
}
