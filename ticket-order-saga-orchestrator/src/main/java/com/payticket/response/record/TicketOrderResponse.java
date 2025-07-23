package com.payticket.response.record;

import com.payticket.constants.OrderStatus;
import lombok.Builder;

import java.util.UUID;

@Builder
public record TicketOrderResponse(String ticketOrderId, OrderStatus orderStatus) {}
