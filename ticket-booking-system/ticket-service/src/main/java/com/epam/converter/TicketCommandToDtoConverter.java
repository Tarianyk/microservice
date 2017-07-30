package com.epam.converter;

import com.epam.domain.TicketCommand;
import com.epam.dto.TicketDto;
import org.springframework.core.convert.converter.Converter;

public class TicketCommandToDtoConverter implements Converter<TicketCommand, TicketDto> {

    @Override
    public TicketDto convert(TicketCommand ticketCommand) {
        TicketDto ticketDto = new TicketDto();
        ticketDto.setId(ticketCommand.getId());
        ticketDto.setUserId(ticketCommand.getUserId());
        ticketDto.setEventId(ticketCommand.getEventId());
        ticketDto.setPlace(ticketCommand.getPlace());
        ticketDto.setPrice(ticketCommand.getPrice());
//        ticketCommand.setCategory(ticketDto.getCategory());

        return ticketDto;
    }
}
