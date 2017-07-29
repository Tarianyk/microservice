package com.epam.services;

import com.epam.domain.BookingReport;
import com.epam.domain.TicketQuery;

import java.util.List;

public interface ITicketQueryService {

    /**
     * Get all booked tickets for specified user. Tickets should be sorted by event date in descending order.
     *
     * @param pageSize Pagination param. Number of tickets to return on a page.
     * @param pageNum  Pagination param. Number of the page to return. Starts from 1.
     * @return List of TicketQuery objects.
     */
    List<TicketQuery> getBookedTicketsForUser(long userId, int pageSize, int pageNum);

    /**
     * Get all booked tickets for specified event. Tickets should be sorted in by user email in ascending order.
     *
     * @param pageSize Pagination param. Number of tickets to return on a page.
     * @param pageNum  Pagination param. Number of the page to return. Starts from 1.
     * @return List of TicketQuery objects.
     */
    List<TicketQuery> getBookedTicketsForEvent(long eventId, int pageSize, int pageNum);

    /**
     * Get summary booking report by event.
     *
     * @return List of booking reports by event.
     **/
    List<BookingReport> getBookingReports();

}
