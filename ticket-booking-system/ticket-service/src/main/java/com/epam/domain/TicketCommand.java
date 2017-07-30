package com.epam.domain;

import lombok.Data;
import lombok.ToString;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "ticket_command")
@Data
@ToString
public class TicketCommand {
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