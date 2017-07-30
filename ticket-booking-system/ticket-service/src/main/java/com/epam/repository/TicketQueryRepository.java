package com.epam.repository;

import com.epam.domain.TicketQuery;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TicketQueryRepository extends JpaRepository<TicketQuery, Long> {
    List<TicketQuery> findAllByUserId(@Param("userId") long userId, Pageable pageable);

    List<TicketQuery> findAllByEventId(@Param("eventId") long eventId, Pageable pageable);
}
