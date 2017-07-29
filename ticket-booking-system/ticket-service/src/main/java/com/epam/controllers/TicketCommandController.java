package com.epam.controllers;

import com.epam.domain.TicketCommand;
import com.epam.dto.TicketCommandDto;
import com.epam.services.ITicketCommandService;
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
    ResponseEntity<TicketCommand> bookTicket(@RequestBody TicketCommandDto bookTicketCommandDto) {
        TicketCommand ticketCommand = ticketCommandService.bookTicket(bookTicketCommandDto);

        return new ResponseEntity<TicketCommand>(ticketCommand, HttpStatus.OK);
    }

    @RequestMapping(value = "/cancel/id/{ticketId}", method = RequestMethod.POST)
    ResponseEntity<Boolean> cancelTicket(@PathVariable("ticketId") long ticketId) {
        return new ResponseEntity<Boolean>(ticketCommandService.cancelTicket(ticketId), HttpStatus.OK);
    }

    @RequestMapping(value = "/test", method = RequestMethod.GET)
    ResponseEntity<String> test() {
        System.out.println("LOOOOL");
        rabbitMessagingTemplate.convertAndSend("exchange", "queue", foo);queue1
        return new ResponseEntity<String>("OKAY", HttpStatus.OK);
    }

}
