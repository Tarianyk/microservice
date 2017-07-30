package com.epam.exception;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.http.HttpStatus;

@AllArgsConstructor
@Data
public class BookTicketException extends RuntimeException {
    private String message;
    private HttpStatus status;
}
