package com.payticket.web.controller;

import com.payticket.dto.TicketOrderDto;
import com.payticket.response.BasicResponse;
import com.payticket.response.record.TicketOrderResponse;
import com.payticket.service.TicketOrderService;
import com.payticket.utils.ValidatorUtils;
import lombok.extern.log4j.Log4j2;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Log4j2
@RequestMapping("api/v1/ticket/order")
@RestController
public class TicketOrderController {

    private final TicketOrderService ticketOrderService;
    private final ValidatorUtils validatorUtils;

    public TicketOrderController(TicketOrderService ticketOrderService, ValidatorUtils validatorUtils) {
        this.ticketOrderService = ticketOrderService;
        this.validatorUtils = validatorUtils;
    }

    @RequestMapping(method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<BasicResponse<TicketOrderResponse>> createTicketOrder(@RequestBody TicketOrderDto ticketOrderDto) {
        //List<String> result = validatorUtils.validationBeforeDeserialization(ticketOrderDto);
       // log.info(result);
        return ResponseEntity.accepted().body(ticketOrderService.processOrder(ticketOrderDto));
    }

}
