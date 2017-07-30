package com.epam.services;

import com.epam.domain.TicketCommand;
import com.epam.dto.TicketDto;

public interface ITicketCommandService {

    /**
     * Book ticket for a specified event on behalf of specified user.
     *
     * @return Booked ticket object.
     * @throws java.lang.IllegalStateException if this place has already been booked.
     */
    TicketCommand bookTicket(TicketDto ticketDto);

    /**
     * Cancel ticket with a specified id.
     *
     * @param ticketId TicketCommand id.
     * @return Flag whether anything has been canceled.
     */
    boolean cancelTicket(long ticketId);

}
