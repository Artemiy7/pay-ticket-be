package com.payticket.transformer;

import com.payticket.dto.TicketDto;
import com.payticket.entity.TicketEntity;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Component
public class TicketDtoToTicketEntity implements Transformer<TicketDto, TicketEntity> {
    @Override
    public TicketEntity transform(TicketDto dto)  {
        return TicketEntity.builder()
                .price(dto.getPrice())
                .seatNumber(dto.getSeatNumber())
                .seatPlaceType(dto.getSeatPlaceType())
                .createdAt(LocalDateTime.now())
                .build();
    }
}
