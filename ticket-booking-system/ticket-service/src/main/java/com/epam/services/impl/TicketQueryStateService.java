package com.epam.services.impl;

import com.epam.domain.TicketQuery;
import com.epam.repository.TicketQueryRepository;
import com.epam.services.ITicketQueryStateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class TicketQueryStateService implements ITicketQueryStateService {

    @Autowired
    private TicketQueryRepository ticketQueryRepository;

    @Override
    public TicketQuery saveTicket(TicketQuery ticketQuery) {
        return ticketQueryRepository.save(ticketQuery);
    }
}
