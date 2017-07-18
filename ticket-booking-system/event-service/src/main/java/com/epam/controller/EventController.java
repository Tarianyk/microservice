package com.epam.controller;

import com.epam.domain.Event;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;
import java.util.List;

@RestController
public class EventController {

    @RequestMapping(value = "")
    public ResponseEntity<Event> getEventById() {
        return null;
    }

    List<Event> getEventsByTitle(String title, int pageSize, int pageNum) {
        return null;
    }

    List<Event> getEventsForDay(Date day, int pageSize, int pageNum) {
        return null;
    }

    Event createEvent(Event event) {
        return null;
    }

    Event updateEvent(Event event) {
        return null;
    }

    boolean deleteEvent(long eventId) {
        return false;
    }
}
