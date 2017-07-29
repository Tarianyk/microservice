package com.epam.converter;

import com.epam.domain.Event;
import com.epam.dto.EventDto;
import org.springframework.core.convert.converter.Converter;

import java.util.Date;

public class EventConverter implements Converter<EventDto, Event> {

    @Override
    public Event convert(EventDto eventDto) {
        Event event = new Event();
        event.setId(eventDto.getId());
        event.setTitle(eventDto.getTitle());
        event.setDate(new Date(eventDto.getDate()));

        return event;
    }
}
