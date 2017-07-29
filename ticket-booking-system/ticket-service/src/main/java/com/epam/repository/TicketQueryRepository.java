package com.epam.repository;

import com.epam.domain.TicketCommand;
import com.epam.domain.TicketQuery;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TicketQueryRepository extends JpaRepository<TicketQuery, Long> {
}
