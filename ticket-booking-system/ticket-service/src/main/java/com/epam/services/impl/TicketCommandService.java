package com.epam.services.impl;

import com.epam.domain.TicketCommand;
import com.epam.dto.TicketDto;
import com.epam.exception.BookTicketException;
import com.epam.repository.TicketCommandRepository;
import com.epam.services.ICheck;
import com.epam.services.ITicketCommandService;
import org.springframework.amqp.rabbit.core.RabbitMessagingTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.ConversionService;
import org.springframework.http.HttpStatus;
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
    @Autowired
    private ICheck check;
    @Autowired
    private RabbitMessagingTemplate rabbitMessagingTemplate;

    @Override
    public TicketCommand bookTicket(TicketDto ticketDto) {
        checkOnExistingUserAndEvent(ticketDto);
        checkOnExistingBookedPlace(ticketDto);

        TicketCommand savedEntity = ticketCommandRepository.save(conversionService.convert(ticketDto, TicketCommand.class));
        if (Objects.nonNull(savedEntity)) {
            rabbitMessagingTemplate.convertAndSend("queue1", conversionService.convert(savedEntity, TicketDto.class));
        } else {
            throw new BookTicketException("The error was invoked during saving Ticket entity into command storage.", HttpStatus.OK);
        }

        return savedEntity;
    }

    private void checkOnExistingBookedPlace(TicketDto ticketDto) {
        TicketCommand ticketCommandByPlace = ticketCommandRepository.findTicketByPlace(ticketDto.getPlace());
        if (Objects.nonNull(ticketCommandByPlace)) {
            throw new IllegalStateException("Specified place has already been booked.");
        }
    }

    private void checkOnExistingUserAndEvent(TicketDto ticketDto) {
        if (!check.userExists(ticketDto.getUserId()) | !check.eventExists(ticketDto.getEventId())) {
            throw new BookTicketException("Event or User entities doesnt exist.", HttpStatus.BAD_REQUEST);
        }
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
