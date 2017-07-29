package com.epam.services.impl;

import com.epam.domain.BookingReport;
import com.epam.domain.TicketQuery;
import com.epam.repository.TicketQueryRepository;
import com.epam.services.ITicketQueryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class TicketQueryService implements ITicketQueryService {

    @Autowired
    private TicketQueryRepository ticketQueryRepository;

    @Override
    public List<TicketQuery> getBookedTicketsForUser(long userId, int pageSize, int pageNum) {
        return null;
    }

    @Override
    public List<TicketQuery> getBookedTicketsForEvent(long eventId, int pageSize, int pageNum) {
        return null;
    }

    @Override
    public List<BookingReport> getBookingReports() {
        return null;
    }
}
