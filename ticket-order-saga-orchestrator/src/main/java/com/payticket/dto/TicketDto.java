package com.payticket.dto;

import lombok.*;

import java.math.BigDecimal;

@Getter
@Builder
@ToString
@AllArgsConstructor
public class TicketDto {
    private BigDecimal price;
    private int seatNumber;
    private String seatPlaceType;
}
