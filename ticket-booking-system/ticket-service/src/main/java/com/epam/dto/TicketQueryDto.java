package com.epam.dto;

import lombok.Data;

import javax.validation.constraints.NotNull;

@Data
public class TicketQueryDto {
    @NotNull
    private long userId;
    @NotNull
    private long eventId;
    @NotNull
    private int place;
    @NotNull
    private int price;

}