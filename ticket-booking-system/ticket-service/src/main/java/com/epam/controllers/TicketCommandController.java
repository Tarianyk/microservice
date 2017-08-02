package com.epam.controllers;

import com.epam.domain.TicketCommand;
import com.epam.dto.TicketDto;
import com.epam.services.ITicketCommandService;
import org.springframework.amqp.rabbit.core.RabbitMessagingTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class TicketCommandController {

    @Autowired
    private ITicketCommandService ticketCommandService;
    @Autowired
    private RabbitMessagingTemplate rabbitMessagingTemplate;

    @RequestMapping(value = "/book", method = RequestMethod.POST)
    ResponseEntity<TicketCommand> bookTicket(@RequestBody TicketDto bookTicketDto) {
        TicketCommand ticketCommand = ticketCommandService.bookTicket(bookTicketDto);

        return new ResponseEntity<TicketCommand>(ticketCommand, HttpStatus.OK);
    }

    @RequestMapping(value = "/cancel/id/{ticketId}", method = RequestMethod.POST)
    ResponseEntity<Boolean> cancelTicket(@PathVariable("ticketId") long ticketId) {

        return new ResponseEntity<Boolean>(ticketCommandService.cancelTicket(ticketId), HttpStatus.OK);
    }

}
