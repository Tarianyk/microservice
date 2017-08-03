package com.epam.repository;

import com.epam.domain.BookingReport;
import com.epam.domain.TicketQuery;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TicketQueryRepository extends JpaRepository<TicketQuery, Long> {
    List<TicketQuery> findAllByUserId(@Param("userId") long userId, Pageable pageable);

    List<TicketQuery> findAllByEventId(@Param("eventId") long eventId, Pageable pageable);

    @Query("select t.eventId, count(t.place) ,sum(t.price) from TicketQuery  t WHERE t.eventId =:eventId")
    List<BookingReport> findBookingReports(@Param("eventId") long eventId);
}
