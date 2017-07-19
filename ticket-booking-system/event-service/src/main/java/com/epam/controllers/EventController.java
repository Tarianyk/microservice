package com.epam.controllers;

import com.epam.domain.Event;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.Date;
import java.util.List;

@RestController
public class EventController {

    @RequestMapping(value = "", method = RequestMethod.GET)
    public ResponseEntity<Event> getEventById() {
        return null;
    }

    List<Event> getEventsByTitle(String title, int pageSize, int pageNum) {
        return null;
    }

    List<Event> getEventsForDay(Date day, int pageSize, int pageNum) {
        return null;
    }

    @RequestMapping(value = "/create", method = RequestMethod.POST)
    Event createEvent(@RequestBody @Valid Event event) {

        return null;
    }

    Event updateEvent(Event event) {
        return null;
    }

    boolean deleteEvent(long eventId) {
        return false;
    }
}
