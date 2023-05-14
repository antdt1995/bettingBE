package com.axonactive.personalproject.exception;

import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.time.format.DateTimeParseException;

@ControllerAdvice
public class RestExceptionHandler extends ResponseEntityExceptionHandler {
    @ExceptionHandler({ ResponseException.class })
    public ResponseEntity<Object> handleAll(final ResponseException e, final WebRequest request) {
        logger.error("error", e);

        return new ResponseEntity<>(e.getResponseBody(), new HttpHeaders(), e.getResponseBody().getHttpStatus());
    }
    @ExceptionHandler(DateTimeParseException.class)
    public ResponseEntity<Object> handleInvalidDateFormat(DateTimeParseException ex) {
        String errorMessage = "Invalid date format: " + ex.getParsedString();
        ResponseException responseException = ProjectException.badRequest("InvalidDateFormat", errorMessage);
        logger.error("Error occurred", ex);
        return new ResponseEntity<>(responseException.getResponseBody(), new HttpHeaders(), responseException.getResponseBody().getHttpStatus());
    }
}
