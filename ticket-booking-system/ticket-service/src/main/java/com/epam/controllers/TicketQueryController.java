package com.epam.controllers;

import com.epam.domain.BookingReport;
import com.epam.domain.TicketQuery;
import com.epam.services.ITicketQueryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.constraints.NotNull;
import java.util.List;

@RestController
public class TicketQueryController {

    @Autowired
    private ITicketQueryService ticketQueryService;

    @RequestMapping(value = "/bookedTickets/user/{userId}", method = RequestMethod.GET)
    public ResponseEntity<List<TicketQuery>> getBookedTicketsForUser(@PathVariable("userId") @NotNull int userId,
                                                                     @RequestParam("pageSize") @NotNull int pageSize,
                                                                     @RequestParam("pageNum") @NotNull int pageNum) {
        List<TicketQuery> bookedTicketsForUser = ticketQueryService.getBookedTicketsForUser(userId, pageSize, pageNum);

        return new ResponseEntity<List<TicketQuery>>(bookedTicketsForUser, HttpStatus.OK);
    }

    @RequestMapping(value = "/bookedTickets/event/{eventId}", method = RequestMethod.GET)
    public ResponseEntity<List<TicketQuery>> getBookedTicketsForEvent(@PathVariable("eventId") int eventId,
                                                                      @RequestParam("pageSize") int pageSize,
                                                                      @RequestParam("pageNum") int pageNum) {
        List<TicketQuery> bookedTicketsForEvent = ticketQueryService.getBookedTicketsForEvent(eventId, pageSize, pageNum);

        return new ResponseEntity<List<TicketQuery>>(bookedTicketsForEvent, HttpStatus.OK);
    }

    @RequestMapping(value = "/bookedTickets/{evenId}", method = RequestMethod.GET)
    public ResponseEntity<List<BookingReport>> getBookingReports(@PathVariable("eventId") int eventId) {
        List<BookingReport> bookingReports = ticketQueryService.getBookingReports(eventId);

        return new ResponseEntity<List<BookingReport>>(bookingReports, HttpStatus.OK);
    }
}
