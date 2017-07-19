package com.epam.repository;

import com.epam.domain.Event;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public interface EventRepository extends JpaRepository<Event, Long> {

    //TODO: remake
    @Query("select event from Event event where event.title like %:title%")
    List<Event> findEventsByTitle(@Param("title") String title, Pageable pageable);

    List<Event> findEventsByDate(@Param("date") Date date, Pageable pageable);
}
