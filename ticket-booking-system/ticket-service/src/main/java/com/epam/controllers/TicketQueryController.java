package com.epam.controllers;

import com.epam.domain.BookingReport;
import com.epam.domain.TicketQuery;
import com.epam.services.ITicketQueryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class TicketQueryController {

    @Autowired
    private ITicketQueryService tickeQueryService;

    /**
     * Get all booked tickets for specified user. Tickets should be sorted by event date in descending order.
     *
     * @param pageSize Pagination param. Number of tickets to return on a page.
     * @param pageNum  Pagination param. Number of the page to return. Starts from 1.
     * @return List of TicketQuery objects.
     */
    @RequestMapping(value = "/bookedTickets/user/{userId}", method = RequestMethod.GET)
    public ResponseEntity<List<TicketQuery>> getBookedTicketsForUser(@PathVariable("userId") int userId,
                                                                     @RequestParam("pageSize") int pageSize,
                                                                     @RequestParam("pageNum") int pageNum) {

        return null;
    }

    @RequestMapping(value = "/bookedTickets/event/{eventId}", method = RequestMethod.GET)
    public ResponseEntity<List<TicketQuery>> getBookedTicketsForEvent(@PathVariable("eventId") int eventId,
                                                                      @RequestParam("pageSize") int pageSize,
                                                                      @RequestParam("pageNum") int pageNum) {
        return null;
    }

    @RequestMapping(value = "/bookedTickets", method = RequestMethod.GET)
    public ResponseEntity<List<BookingReport>> getBookingReports() {
        return null;
    }
}
