package com.epam.exceptions_handler;

import com.epam.dto.ValidationErrorDto;
import com.epam.exception.BookTicketException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.util.ArrayList;
import java.util.List;

@ControllerAdvice
@Slf4j
public class GeneralExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(Exception.class)
    public ResponseEntity<?> handleOtherExceptions(IllegalStateException e) {
        log.debug(e.getMessage(), e);
        return new ResponseEntity<String>(e.getMessage(), HttpStatus.CONFLICT);
    }

    @ExceptionHandler(IllegalStateException.class)
    public ResponseEntity<?> handleUserExistException(IllegalStateException e) {
        log.debug("User doesn't exist.", e);
        return new ResponseEntity<String>(e.getMessage(), HttpStatus.CONFLICT);
    }

    @ExceptionHandler(BookTicketException.class)
    public ResponseEntity<?> handleUserOrEventDoesntExist(BookTicketException e) {
        log.debug("User or Event doesn't exist.", e);
        return new ResponseEntity<String>(e.getMessage(), e.getStatus());
    }

    @Override
    protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex,
                                                                  HttpHeaders headers,
                                                                  HttpStatus status,
                                                                  WebRequest request) {
        log.debug("Method contains invalid arguments.", ex);

        List<String> errors = new ArrayList<String>();
        for (FieldError error : ex.getBindingResult().getFieldErrors()) {
            errors.add(error.getField() + ": " + error.getDefaultMessage());
        }
        for (ObjectError error : ex.getBindingResult().getGlobalErrors()) {
            errors.add(error.getObjectName() + ": " + error.getDefaultMessage());
        }

        ValidationErrorDto validationErrorDto =
                new ValidationErrorDto(HttpStatus.BAD_REQUEST, ex.getLocalizedMessage(), errors);

        return handleExceptionInternal(ex, validationErrorDto, headers, validationErrorDto.getStatus(), request);
    }
}
