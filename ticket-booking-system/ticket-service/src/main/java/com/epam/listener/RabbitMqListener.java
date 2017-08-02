package com.epam.listener;


import com.epam.domain.TicketQuery;
import com.epam.dto.TicketDto;
import com.epam.services.ITicketQueryStateService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.annotation.EnableRabbit;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.ConversionService;
import org.springframework.stereotype.Component;

@EnableRabbit
@Component
@Slf4j
public class RabbitMqListener {

    @Autowired
    private ConversionService conversionService;
    @Autowired
    private ITicketQueryStateService ticketQueryService;

    @RabbitListener(queues = "queue1")
    public void processQueue1(TicketDto ticketDto) {
        log.info("The listener was called.");

        TicketQuery ticketQuery = conversionService.convert(ticketDto, TicketQuery.class);
        ticketQueryService.saveTicket(ticketQuery);
    }

}