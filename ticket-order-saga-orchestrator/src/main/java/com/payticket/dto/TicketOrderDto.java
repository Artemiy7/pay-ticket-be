package com.payticket.dto;

import com.payticket.constants.OrderStatus;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import lombok.*;

import java.util.Set;
import java.util.UUID;

@Getter
@ToString
@Builder
@AllArgsConstructor
public class TicketOrderDto {
    private UUID idempotencyId;
    @NotEmpty
    private String customerFirstName;
    @NotEmpty
    private String customerLastName;
    @NotEmpty
    @Email
    private String customerEmail;
    private boolean sendOnEmail;
    private Set<TicketDto>  ticketDtoSet;
    private UUID occasionId;
    private String occasionName;
    private String currency;
    private String callbackUrl;
    private String callbackMethod;
}
