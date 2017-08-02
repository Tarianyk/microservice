package com.epam.services.impl;

import com.epam.domain.TicketQuery;
import com.epam.exception.BookTicketException;
import com.epam.repository.TicketQueryRepository;
import com.epam.services.ITicketQueryService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpStatus;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import static org.hamcrest.Matchers.instanceOf;
import static org.junit.Assert.*;

@RunWith(SpringJUnit4ClassRunner.class)
public class TicketQueryServiceTest {

    @Mock
    private ITicketQueryService ticketQueryService;
    @Mock
    private TicketQueryRepository ticketQueryRepository;

//    @Override
//    public List<TicketQuery> getBookedTicketsForUser(long userId, int pageSize, int pageNum) {
//        Optional<List<TicketQuery>> bookedTickets = Optional.ofNullable(ticketQueryRepository.findAllByUserId(userId, new PageRequest(pageSize, pageNum)));
//        if (!bookedTickets.isPresent() | bookedTickets.get().size() == 0) {
//            throw new BookTicketException("Tickets by current id doesnt exist.", HttpStatus.BAD_REQUEST);
//        }
//
//        Map<TicketQuery, Long> bookedTicketAndDate = new HashMap<>();
//        bookedTickets.get().forEach(entry -> bookedTicketAndDate.put(entry, getEventDateFromJson(entry)));
//
//        return getSortedList(bookedTicketAndDate);
//    }


    @Test
    public void test_ml_always_return_true() {
        Mockito.when(ticketQueryRepository.findAllByUserId(Mockito.anyLong(), Mockito.anyObject())).thenReturn(null);
        List<TicketQuery> bookedTicketsForUser = ticketQueryService.getBookedTicketsForUser(Mockito.anyLong(), Mockito.anyInt(), Mockito.anyInt());
        System.out.println(Optional.ofNullable(null));
        Optional<Object> o = Optional.ofNullable(null);
        System.out.println(o.isPresent());
    }

}