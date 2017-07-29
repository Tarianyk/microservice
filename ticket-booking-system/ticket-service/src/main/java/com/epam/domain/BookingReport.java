package com.epam.domain;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "bookingReport")
@Data
public class BookingReport {
    private long eventId;
    private int totalBookedSeats;
    private int totalRevenue;
}
