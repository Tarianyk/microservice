package com.epam.dto;

import lombok.Data;
import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotEmpty;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Data
public class UserDto {
    private long id;
    @NotEmpty
    @NotNull
    @Size(min = 3, max = 10, message = "Error in size")
    private String name;
    @NotEmpty
    @NotNull
    @Email
    private String email;
}