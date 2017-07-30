package com.epam.converter;

import com.epam.domain.TicketQuery;
import com.epam.dto.TicketDto;
import org.springframework.core.convert.converter.Converter;

public class TicketDtoToTicketQueryConverter implements Converter<TicketDto, TicketQuery> {

    @Override
    public TicketQuery convert(TicketDto ticketDto) {
        TicketQuery ticketQuery = new TicketQuery();
        ticketQuery.setId(ticketDto.getId());
        ticketQuery.setUserId(ticketDto.getUserId());
        ticketQuery.setEventId(ticketDto.getEventId());
        ticketQuery.setPlace(ticketDto.getPlace());
        ticketQuery.setPrice(ticketDto.getPrice());
//        ticketCommand.setCategory(ticketDto.getCategory());

        return ticketQuery;
    }
}
