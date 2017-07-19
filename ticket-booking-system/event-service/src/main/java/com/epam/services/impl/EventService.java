package com.epam.services.impl;

import com.epam.domain.Event;
import com.epam.repository.EventRepository;
import com.epam.services.IEventService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class EventService implements IEventService {

    @Autowired
    private EventRepository eventRepository;

    @Override
    public Event getEventById(long eventId) {
        return eventRepository.findOne(eventId);
    }

    @Override
    public List<Event> getEventsByTitle(String title, int pageSize, int pageNum) {
        return eventRepository.findEventsByTitle(title, new PageRequest(pageSize, pageNum));
    }

    @Override
    public List<Event> getEventsForDay(Date day, int pageSize, int pageNum) throws ParseException {
        return eventRepository.findEventsByDate(day, new PageRequest(pageSize, pageNum));
    }

    @Override
    public Event createEvent(Event event) {
        return eventRepository.save(event);
    }

    @Override
    public Event updateEvent(Event event) {
        return eventRepository.save(event);
    }

    @Override
    public void deleteEvent(long eventId) {
        eventRepository.delete(eventId);
    }

    @Override
    public boolean isEventExists(Event event) {
        return Optional.ofNullable(eventRepository.findOne(event.getId())).isPresent();
    }
}
