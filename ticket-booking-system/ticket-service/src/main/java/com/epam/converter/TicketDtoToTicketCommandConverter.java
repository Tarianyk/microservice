package com.epam.converter;

import com.epam.domain.TicketCommand;
import com.epam.dto.TicketDto;
import org.springframework.core.convert.converter.Converter;

public class TicketDtoToTicketCommandConverter implements Converter<TicketDto, TicketCommand> {

    @Override
    public TicketCommand convert(TicketDto ticketDto) {
        TicketCommand ticketCommand = new TicketCommand();
        ticketCommand.setId(ticketDto.getId());
        ticketCommand.setUserId(ticketDto.getUserId());
        ticketCommand.setEventId(ticketDto.getEventId());
        ticketCommand.setPlace(ticketDto.getPlace());
        ticketCommand.setPrice(ticketDto.getPrice());
//        ticketCommand.setCategory(ticketDto.getCategory());

        return ticketCommand;
    }
}
