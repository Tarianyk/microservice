package com.epam.services.impl;

import com.epam.domain.Ticket;
import com.epam.services.ITicketCommandService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class TicketCommandService implements ITicketCommandService {

    @Override
    public Ticket bookTicket(long userId, long eventId, int place, Ticket.Category category) {
        return null;
    }

    @Override
    public boolean cancelTicket(long ticketId) {
        return false;
    }
}
