package com.payticket.entity;

import lombok.*;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Setter
@Getter
@Builder
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class TicketEntity {
    private BigDecimal price;
    private int seatNumber;
    private String seatPlaceType;
    private LocalDateTime createdAt;
}
