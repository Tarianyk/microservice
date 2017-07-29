package com.epam.dto;

import lombok.Data;
import org.hibernate.validator.constraints.NotEmpty;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

@Data
public class EventDto {
    private long id;
    @NotEmpty
    @NotNull
    @Size(min = 3, max = 10, message = "Error in size")
    private String title;
    @NotNull
    @Pattern(regexp = "(0?[1-9]|[12][0-9]|3[01])/(0?[1-9]|1[012])/((19|20)\\d\\d)")
    private String date;

}
