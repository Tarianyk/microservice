package com.epam.services.impl;

import com.epam.domain.BookingReport;
import com.epam.domain.Event;
import com.epam.domain.Ticket;
import com.epam.domain.User;
import com.epam.services.ITickeQueryService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class TickeQueryService implements ITickeQueryService {

    @Override
    public Ticket bookTicket(long userId, long eventId, int place, Ticket.Category category) {
        return null;
    }

    @Override
    public List<Ticket> getBookedTickets(User user, int pageSize, int pageNum) {
        return null;
    }

    @Override
    public List<Ticket> getBookedTickets(Event event, int pageSize, int pageNum) {
        return null;
    }

    @Override
    public boolean cancelTicket(long ticketId) {
        return false;
    }

    @Override
    public List<BookingReport> getBookingReports() {
        return null;
    }
}
