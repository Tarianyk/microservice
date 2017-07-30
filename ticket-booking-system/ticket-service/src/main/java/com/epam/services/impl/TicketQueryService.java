package com.epam.services.impl;

import com.epam.domain.BookingReport;
import com.epam.domain.TicketQuery;
import com.epam.exception.BookTicketException;
import com.epam.repository.TicketQueryRepository;
import com.epam.services.ITicketQueryService;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.client.RestTemplate;

import java.util.*;
import java.util.stream.Collectors;

@Service
@Transactional
public class TicketQueryService implements ITicketQueryService {

    private static final String URL_GET_EVENT_BY_ID = "http://localhost:8079/api/event/id/{id}";

    @Autowired
    private TicketQueryRepository ticketQueryRepository;
    @Autowired
    private RestTemplate restTemplate;

    @Override
    public List<TicketQuery> getBookedTicketsForUser(long userId, int pageSize, int pageNum) {
        Optional<List<TicketQuery>> bookedTickets = Optional.ofNullable(ticketQueryRepository.findAllByUserId(userId, new PageRequest(pageSize, pageNum)));
        if (!bookedTickets.isPresent() | bookedTickets.get().size() == 0) {
            throw new BookTicketException("Tickets by current id doesnt exist.", HttpStatus.BAD_REQUEST);
        }

        Map<TicketQuery, Long> bookedTicketAndDate = new HashMap<>();
        bookedTickets.get().forEach(entry -> bookedTicketAndDate.put(entry, getDateFromJson(entry)));

        return getSortedList(bookedTicketAndDate);
    }

    private List<TicketQuery> getSortedList(Map<TicketQuery, Long> bookedTicketAndDate) {
        Map<TicketQuery, Long> collect = bookedTicketAndDate.entrySet()
                .stream()
                .sorted(Map.Entry.<TicketQuery, Long>comparingByValue())
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue));

        return new ArrayList<>(collect.keySet());
    }

    private Long getDateFromJson(TicketQuery entry) {
        JSONObject json = null;
        try {
            json = (JSONObject) new JSONParser().parse(restTemplate.getForEntity(URL_GET_EVENT_BY_ID, String.class, entry.getEventId()).getBody());
        } catch (ParseException e) {
            e.printStackTrace();
        }

        return (Long) json.get("date");
    }

    @Override
    public List<TicketQuery> getBookedTicketsForEvent(long eventId, int pageSize, int pageNum) {
        Optional<List<TicketQuery>> bookedTickets = Optional.ofNullable(ticketQueryRepository.findAllByEventId(eventId, new PageRequest(pageSize, pageNum)));
        if (!bookedTickets.isPresent() | bookedTickets.get().size() == 0) {
            throw new BookTicketException("Tickets by current id doesnt exist.", HttpStatus.BAD_REQUEST);
        }

        Map<TicketQuery, Long> bookedTicketAndDate = new HashMap<>();
        bookedTickets.get().forEach(entry -> bookedTicketAndDate.put(entry, getDateFromJson(entry)));

        return getSortedList(bookedTicketAndDate);
    }

    @Override
    public List<BookingReport> getBookingReports() {
        return null;
    }
}
