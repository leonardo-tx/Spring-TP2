package com.crud.game.api.handler;

import com.crud.game.api.dto.ApiResponse;
import com.crud.game.core.generic.exception.NotFoundException;
import com.crud.game.core.generic.exception.ValidationException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class RestExceptionHandler {
    private static final Logger logger = LoggerFactory.getLogger(RestExceptionHandler.class);

    @ExceptionHandler(ValidationException.class)
    public ResponseEntity<ApiResponse<Object>> validationException(ValidationException e) {
        return ApiResponse.error(HttpStatus.BAD_REQUEST, e).createResponse();
    }

    @ExceptionHandler(NotFoundException.class)
    public ResponseEntity<ApiResponse<Object>> notFoundException(NotFoundException e) {
        return ApiResponse.error(HttpStatus.NOT_FOUND, e).createResponse();
    }
}
