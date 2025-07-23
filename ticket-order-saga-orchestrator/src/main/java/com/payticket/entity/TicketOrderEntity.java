package com.payticket.entity;

import com.payticket.constants.OrderStatus;
import lombok.*;

import java.math.BigDecimal;
import java.time.Duration;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.Arrays;
import java.util.List;
import java.util.Set;
import java.util.function.BiPredicate;
import java.util.function.Predicate;

@Setter
@Getter
@Builder
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class TicketOrderEntity {
    private String id;
    private String customerFirstName;
    private String customerLastName;
    private String customerEmail;
    private boolean sendOnEmail;
    private String occasionId;
    private String occasionName;
    private BigDecimal amount;
    private String currency;
    private String callbackUrl;
    private String callbackMethod;
    private OrderStatus status;
    private Set<TicketEntity> ticketEntitySet;
    private LocalDateTime createdAt;


}
