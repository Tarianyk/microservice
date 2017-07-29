package com.epam.repository;

import com.epam.domain.TicketCommand;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface TicketCommandRepository extends JpaRepository<TicketCommand, Long> {
    TicketCommand findTicketByPlace(@Param("place") int place);
}
