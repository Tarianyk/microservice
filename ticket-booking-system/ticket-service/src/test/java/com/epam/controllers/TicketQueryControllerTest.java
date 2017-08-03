package com.epam.controllers;

import com.epam.domain.TicketQuery;
import com.epam.repository.TicketQueryRepository;
import com.epam.services.ITicketQueryService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.skyscreamer.jsonassert.JSONAssert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.util.Collections;
import java.util.List;

@RunWith(SpringRunner.class)
@WebMvcTest(value = TicketQueryController.class, secure = false)
public class TicketQueryControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private ITicketQueryService ticketQueryService;
    @MockBean
    private TicketQueryRepository ticketQueryRepository;

    @Test
    public void retrieveDetailsForCourse() throws Exception {
        List<TicketQuery> bookedTicketsForUser = Collections.singletonList(new TicketQuery(1, 1, 1, 1, 1));

        Mockito.when(ticketQueryService.getBookedTicketsForUser(Mockito.anyLong(), Mockito.anyInt(), Mockito.anyInt()))
                .thenReturn(bookedTicketsForUser);


        RequestBuilder requestBuilder = MockMvcRequestBuilders.get(
                "/bookedTickets/user/1").param("pageSize", "0").param("pageNum", "1").accept(
                MediaType.APPLICATION_JSON);

        MvcResult result = mockMvc.perform(requestBuilder).andReturn();

        System.out.println("------> " + result.getResponse().getContentAsString());
        String expected = "[{id:1,eventId:1,userId:1,place:1,price:1}]";

        JSONAssert.assertEquals(expected, result.getResponse()
                .getContentAsString(), false);

    }

    @Test
    public void retrieveDetailsForCours123e() throws Exception {
        List<TicketQuery> bookedTicketsForUser = Collections.singletonList(new TicketQuery(1, 1, 1, 1, 1));

        Mockito.when(ticketQueryService.getBookedTicketsForEvent(Mockito.anyLong(), Mockito.anyInt(), Mockito.anyInt()))
                .thenReturn(bookedTicketsForUser);


        RequestBuilder requestBuilder = MockMvcRequestBuilders.get(
                "/bookedTickets/event/1").param("pageSize", "0").param("pageNum", "1").accept(
                MediaType.APPLICATION_JSON);

        MvcResult result = mockMvc.perform(requestBuilder).andReturn();

        System.out.println("------> " + result.getResponse().getContentAsString());
        String expected = "[{id:1,eventId:1,userId:1,place:1,price:1}]";

        JSONAssert.assertEquals(expected, result.getResponse()
                .getContentAsString(), false);

    }



}