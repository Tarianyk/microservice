package com.epam.services;

import com.epam.domain.Event;
import com.epam.dto.EventDto;

import java.text.ParseException;
import java.util.Date;
import java.util.List;

public interface IEventService {

    /**
     * Gets event by its id.
     *
     * @return Event.
     */
    Event getEventById(long eventId);


    /**
     * Get list of events by matching title. Title is matched using 'contains' approach.
     * In case nothing was found, empty list is returned.
     *
     * @param title    Event title or it's part.
     * @param pageSize Pagination param. Number of events to return on a page.
     * @param pageNum  Pagination param. Number of the page to return. Starts from 1.
     * @return List of events.
     */
    List<Event> getEventsByTitle(String title, int pageSize, int pageNum);

    /**
     * Get list of events for specified day.
     * In case nothing was found, empty list is returned.
     *
     * @param day      Date object from which day information is extracted.
     * @param pageSize Pagination param. Number of events to return on a page.
     * @param pageNum  Pagination param. Number of the page to return. Starts from 1.
     * @return List of events.
     */
    List<Event> getEventsForDay(Date day, int pageSize, int pageNum) throws ParseException;


    /**
     * Creates new event. Event id should be auto-generated.
     *
     * @param eventDto Event data.
     * @return Created Event object.
     */
    Event createEvent(EventDto eventDto);


    /**
     * Updates event using given data.
     *
     * @param eventDto Event data for update. Should have id set.
     * @return Updated Event object.
     */
    Event updateEvent(EventDto eventDto);

    /**
     * Deletes event by its id.
     *
     * @param eventId Event id.
     * @return Flag that shows whether event has been deleted.
     */
    void deleteEvent(long eventId);

    public boolean isEventExists(EventDto eventDto);
}
