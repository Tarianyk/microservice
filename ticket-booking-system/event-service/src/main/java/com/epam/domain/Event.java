package com.epam.domain;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Table;
import java.util.Date;

@Entity
@Table(name = "event")
@Data
public class Event {
    private long id;
    private String title;
    private Date date;
}
