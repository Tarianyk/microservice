package com.epam.domain;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import javax.persistence.*;

@Entity
@Table(name = "ticket_query")
@Data
@ToString
@EqualsAndHashCode
public class TicketQuery {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column(name = "eventId")
    private long eventId;
    @Column(name = "userId")
    private long userId;
    @Column(name = "place")
    private int place;
    @Column(name = "price")
    private int price;
//    @Enumerated(EnumType.STRING)
//    @Column(name = "category")
//    private Category category;
//
//    public enum Category {STANDARD, PREMIUM, BAR}
}