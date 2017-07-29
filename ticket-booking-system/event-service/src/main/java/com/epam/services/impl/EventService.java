package com.epam.services.impl;

import com.epam.domain.Event;
import com.epam.dto.EventDto;
import com.epam.repository.EventRepository;
import com.epam.services.IEventService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.ConversionService;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.text.ParseException;
import java.util.Date;
import java.util.List;
import java.util.Objects;

@Service
@Transactional
public class EventService implements IEventService {

    @Autowired
    private EventRepository eventRepository;
    @Autowired
    private ConversionService conversionService;

    @Override
    public Event getEventById(long eventId) {
        return eventRepository.findOne(eventId);
    }

    @Override
    public List<Event> getEventsByTitle(String title, int pageSize, int pageNum) {
        return eventRepository.findEventsByTitleContaining(title, new PageRequest(pageSize, pageNum));
    }

    @Override
    public List<Event> getEventsForDay(Date day, int pageSize, int pageNum) throws ParseException {
        return eventRepository.findEventsByDate(day, new PageRequest(pageSize, pageNum));
    }

    @Override
    public Event createEvent(EventDto eventDto) {
        return eventRepository.save(conversionService.convert(eventDto, Event.class));
    }

    @Override
    public Event updateEvent(EventDto eventDto) {
        Event event = conversionService.convert(eventDto, Event.class);
        eventRepository.updateEvent(event.getDate(), event.getTitle(), event.getId());

        return eventRepository.findOne(event.getId());
    }

    @Override
    public void deleteEvent(long eventId) {
        eventRepository.delete(eventId);
    }

    @Override
    public boolean isEventExists(EventDto eventDto) {
        return Objects.nonNull(eventRepository.findOne(eventDto.getId()));
    }
}
