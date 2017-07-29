package com.epam.repository;

import com.epam.domain.Event;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public interface EventRepository extends JpaRepository<Event, Long> {

    List<Event> findEventsByTitleContaining(@Param("title") String title, Pageable pageable);

    List<Event> findEventsByDate(@Param("date") Date date, Pageable pageable);

    //TODO: check working
    @Modifying
    @Query("update Event e set e.date = ?1, e.title = ?2 where e.id = ?3")
    Event updateEvent(Date date, String title, long id);
}
