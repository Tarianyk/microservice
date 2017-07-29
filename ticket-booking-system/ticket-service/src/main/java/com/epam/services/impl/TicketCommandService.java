package com.epam.services.impl;

import com.epam.domain.TicketCommand;
import com.epam.dto.TicketCommandDto;
import com.epam.repository.TicketCommandRepository;
import com.epam.services.ITicketCommandService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.ConversionService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Objects;

@Service
@Transactional
public class TicketCommandService implements ITicketCommandService {

    @Autowired
    private TicketCommandRepository ticketCommandRepository;
    @Autowired
    private ConversionService conversionService;

    @Override
    public TicketCommand bookTicket(TicketCommandDto ticketCommandDto) {
        TicketCommand ticketCommandByPlace = ticketCommandRepository.findTicketByPlace(ticketCommandDto.getPlace());
        if (!Objects.nonNull(ticketCommandByPlace)) {
            throw new IllegalStateException("Specified place has already been booked.");
        }
        return ticketCommandRepository.save(conversionService.convert(ticketCommandDto, TicketCommand.class));
    }

    /**
     * Cancel ticket with a specified id.
     *
     * @param ticketId TicketCommand id.
     * @return Flag whether anything has been canceled.
     */
    @Override
    public boolean cancelTicket(long ticketId) {
        TicketCommand ticket = ticketCommandRepository.findOne(ticketId);
        if (Objects.nonNull(ticket)) {
            return false;
        }
        ticketCommandRepository.delete(ticketId);
        return true;
    }

}
