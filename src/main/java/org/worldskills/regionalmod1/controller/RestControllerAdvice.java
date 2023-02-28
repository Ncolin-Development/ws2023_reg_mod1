package org.worldskills.regionalmod1.controller;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;
import org.worldskills.regionalmod1.exception.BadRequestException;
import org.worldskills.regionalmod1.exception.NotFoundException;
import org.worldskills.regionalmod1.model.Error;

@ControllerAdvice
public class RestControllerAdvice extends ResponseEntityExceptionHandler {

    @ExceptionHandler(value = {BadRequestException.class})
    protected ResponseEntity<Object> handleBadRequest(BadRequestException exception, WebRequest request) {
        Error error = Error.builder().status("400").message(exception.getMessage()).build();
        return handleExceptionInternal(exception, error, new HttpHeaders(), HttpStatus.BAD_REQUEST, request);
    }

    @ExceptionHandler(value = {NotFoundException.class})
    protected ResponseEntity<Object> handleNotFound(NotFoundException exception, WebRequest request) {
        Error error = Error.builder().status("404").message(exception.getMessage()).build();
        return handleExceptionInternal(exception, error, new HttpHeaders(), HttpStatus.NOT_FOUND, request);
    }
}
