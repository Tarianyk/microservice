package com.epam.controllers;

import com.epam.domain.Event;
import com.epam.exceptions.EventExistsException;
import com.epam.services.IEventService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.text.ParseException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Optional;

@RestController
public class EventController {

    private static final String EVENT_ALREADY_EXISTS = "Event already exists.";
    public static final String DATE_PATTERN = "dd-MM-yyyy";

    @Autowired
    private IEventService eventService;

    @RequestMapping(value = "/id/{eventId}", method = RequestMethod.GET)
    public ResponseEntity<Event> getEventById(@PathVariable(value = "eventId") long eventId) {
        Optional<Event> optEvent = Optional.ofNullable(eventService.getEventById(eventId));

        return optEvent.map(event -> new ResponseEntity<>(event, HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NO_CONTENT));
    }

    //TODO: In case nothing was found, empty list is returned.
    @RequestMapping(value = "/title/{title}", method = RequestMethod.GET)
    ResponseEntity<List<Event>> getEventsByTitle(@PathVariable(value = "title") String title,
                                                 @RequestParam("from") int pageSize,
                                                 @RequestParam("to") int pageNum) {
        Optional<List<Event>> optListOfEvent = Optional.ofNullable(eventService.getEventsByTitle(title, pageSize, pageNum));

        return optListOfEvent.map(events -> new ResponseEntity<List<Event>>(events, HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<List<Event>>(HttpStatus.NO_CONTENT));
    }

    //TODO: In case nothing was found, empty list is returned.
    @RequestMapping(value = "/date", method = RequestMethod.GET)
    ResponseEntity<List<Event>> getEventsForDay(@RequestParam("date") String date,
                                                @RequestParam("from") int pageSize,
                                                @RequestParam("to") int pageNum) throws ParseException {
        LocalDate localDate = LocalDate.parse(date, DateTimeFormatter.ofPattern(DATE_PATTERN));
        Optional<List<Event>> optListOfEvent = Optional.ofNullable(eventService.getEventsForDay(java.sql.Date.valueOf(localDate), pageSize, pageNum));

        return optListOfEvent.map(events -> new ResponseEntity<List<Event>>(events, HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<List<Event>>(HttpStatus.NO_CONTENT));
    }

    @RequestMapping(value = "/create", method = RequestMethod.POST)
    ResponseEntity<Event> createEvent(@RequestBody @Valid Event event) {
        if (eventService.isEventExists(event)) {
            throw new EventExistsException(EVENT_ALREADY_EXISTS, HttpStatus.CONFLICT);
        }
        eventService.createEvent(event);

        return new ResponseEntity<Event>(HttpStatus.CREATED);
    }

    //TODO: remake query
    //TODO: change logic
    @RequestMapping(value = "/update", method = RequestMethod.POST)
    ResponseEntity<Event> updateEvent(@RequestBody @Valid Event event) {
        if (!eventService.isEventExists(event)) {
            throw new EventExistsException(EVENT_ALREADY_EXISTS, HttpStatus.CONFLICT);
        }
        Event updatedEvent = eventService.updateEvent(event);

        return new ResponseEntity<Event>(updatedEvent, HttpStatus.OK);
    }

    @RequestMapping(value = "/delete/{id}", method = RequestMethod.POST)
    ResponseEntity<?> deleteEvent(@PathVariable(value = "id") long id) {
        eventService.deleteEvent(id);

        return new ResponseEntity<String>(HttpStatus.OK);
    }
}
