package com.epam.config;

import com.epam.converter.TicketCommandToDtoConverter;
import com.epam.converter.TicketDtoToTicketCommandConverter;
import com.epam.converter.TicketDtoToTicketQueryConverter;
import org.springframework.context.annotation.Configuration;
import org.springframework.format.FormatterRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

@Configuration
public class ConverterConfiguration extends WebMvcConfigurerAdapter {

    @Override
    public void addFormatters(FormatterRegistry registry) {
        registry.addConverter(new TicketDtoToTicketCommandConverter());
        registry.addConverter(new TicketDtoToTicketQueryConverter());
        registry.addConverter(new TicketCommandToDtoConverter());
    }
}
