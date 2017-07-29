package com.epam.converter;

import com.epam.domain.TicketCommand;
import com.epam.dto.TicketCommandDto;
import org.springframework.core.convert.converter.Converter;

public class TicketCommandConverter implements Converter<TicketCommandDto, TicketCommand> {

    @Override
    public TicketCommand convert(TicketCommandDto ticketCommandDto) {
        TicketCommand ticketCommand = new TicketCommand();
        ticketCommand.setUserId(ticketCommandDto.getUserId());
        ticketCommand.setEventId(ticketCommandDto.getEventId());
        ticketCommand.setPlace(ticketCommandDto.getPlace());
        ticketCommand.setPrice(ticketCommandDto.getPrice());
//        ticketCommand.setCategory(ticketCommandDto.getCategory());

        return ticketCommand;
    }
}
