package com.epam.exceptions_handler;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
@Slf4j
public class GeneralExceptionHandler extends ResponseEntityExceptionHandler {
//
//    @ExceptionHandler(UserExistException.class)
//    public ResponseEntity<?> handleUserExistException(UserExistException e) {
//        return new ResponseEntity<String>(e.getMessage(), e.getStatus());
//    }
//
//    @Override
//    protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex,
//                                                                  HttpHeaders headers,
//                                                                  HttpStatus status,
//                                                                  WebRequest request) {
//        List<String> errors = new ArrayList<String>();
//        for (FieldError error : ex.getBindingResult().getFieldErrors()) {
//            errors.add(error.getField() + ": " + error.getDefaultMessage());
//        }
//        for (ObjectError error : ex.getBindingResult().getGlobalErrors()) {
//            errors.add(error.getObjectName() + ": " + error.getDefaultMessage());
//        }
//
//        ValidationErrorDto validationErrorDto =
//                new ValidationErrorDto(HttpStatus.BAD_REQUEST, ex.getLocalizedMessage(), errors);
//
//        log.info("testtest");
//        return handleExceptionInternal(ex, validationErrorDto, headers, validationErrorDto.getStatus(), request);
//    }
}
