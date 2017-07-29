package com.epam.domain;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "ticket")
@Data
public class Ticket {
    public enum Category {STANDARD, PREMIUM, BAR}

    private long id;
    private long eventId;
    private long userId;
    private Category category;
    private int place;
    private int price;
}