package com.epam.services;

import com.epam.domain.Event;

import java.text.ParseException;
import java.util.Date;
import java.util.List;

public interface IEventService {

    Event getEventById(long eventId);

    List<Event> getEventsByTitle(String title, int pageSize, int pageNum);

    List<Event> getEventsForDay(Date day, int pageSize, int pageNum) throws ParseException;

    Event createEvent(Event event);

    Event updateEvent(Event event);

    void deleteEvent(long eventId);

    public boolean isEventExists(Event event);
}
