package com.payticket.service;

import com.payticket.dto.TicketOrderDto;
import com.payticket.response.BasicResponse;
import com.payticket.response.record.TicketOrderResponse;

public interface TicketOrderService {

    BasicResponse<TicketOrderResponse> processOrder(TicketOrderDto ticketOrderDto);
}
