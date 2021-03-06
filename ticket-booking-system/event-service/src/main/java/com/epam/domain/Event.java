package com.epam.domain;

import lombok.Data;
import org.hibernate.validator.constraints.NotEmpty;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.Date;

@Entity
@Table(name = "event")
@Data
public class Event {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @NotEmpty
    @NotNull
    @Size(min = 3, max = 10, message = "Error in size")
    @Column(name = "title")
    private String title;
    @Column(name = "date", columnDefinition = "DATE")
    private Date date;

    @PrePersist
    protected void onCreate() {
        date = new Date();
    }

    @PreUpdate
    protected void onUpdate() {
        date = new Date();
    }
}