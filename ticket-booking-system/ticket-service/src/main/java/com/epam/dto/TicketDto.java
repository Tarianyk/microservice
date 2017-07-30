package com.epam.dto;

import lombok.Data;

import javax.validation.constraints.NotNull;
import java.io.Serializable;

@Data
public class TicketDto implements Serializable {
    private long id;
    @NotNull
    private long userId;
    @NotNull
    private long eventId;
    @NotNull
    private int place;
    @NotNull
    private int price;
}