package com.epam.services.impl;

import com.epam.config.TicketConfiguration;
import com.epam.domain.TicketCommand;
import com.epam.repository.TicketCommandRepository;
import com.epam.services.ITicketCommandService;
import javafx.beans.binding.When;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.ComponentScans;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.support.AnnotationConfigContextLoader;
import org.springframework.test.context.web.WebAppConfiguration;

import java.util.Objects;

import static org.junit.Assert.*;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = TicketCommandServiceTest.AccountServiceTestContextConfiguration.class)
public class TicketCommandServiceTest {
    @Configuration
    static class AccountServiceTestContextConfiguration {
        @Bean
        public ITicketCommandService accountService() {
            return new TicketCommandService();
        }

    }
    @Autowired
    private TicketCommandService ticketCommandService;
    @MockBean
    private TicketCommandRepository ticketCommandRepository;

    @Test
    public void test1() {
        Mockito.when(ticketCommandRepository.findOne(Mockito.anyLong())).thenReturn(null);
        boolean b = ticketCommandService.cancelTicket(Mockito.anyLong());
        assertEquals(false, b);
    }

    @Test
    public void test2() {
        boolean b = ticketCommandService.cancelTicket(Mockito.anyLong());
        Mockito.when(ticketCommandRepository.findOne(Mockito.anyLong())).thenReturn(new TicketCommand());
        assertEquals(true, b);
    }



}