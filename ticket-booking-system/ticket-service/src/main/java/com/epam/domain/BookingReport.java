package com.epam.domain;

import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "bookingReport")
@Data
public class BookingReport {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @NotNull
    private long eventId;
    @NotNull
    private int totalBookedSeats;
    @NotNull
    private int totalRevenue;
}
