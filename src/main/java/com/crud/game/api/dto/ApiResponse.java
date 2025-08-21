package com.crud.game.api.dto;

import com.crud.game.core.generic.exception.CoreException;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

@Getter
public final class ApiResponse<T> {
    @JsonIgnore
    private final HttpStatus status;
    private final boolean success;
    private final T result;
    private final ErrorData error;

    private ApiResponse(HttpStatus status, boolean success, T result, ErrorData error) {
        this.status = status;
        this.success = success;
        this.result = result;
        this.error = error;
    }

    public static <T> ApiResponse<T> success(HttpStatus status, T result) {
        return new ApiResponse<>(status, true, result, null);
    }

    public static <T> ApiResponse<T> error(HttpStatus status, CoreException coreException) {
        ErrorData error = new ErrorData(coreException.getCode(), coreException.getMessage());
        return new ApiResponse<>(status, false, null, error);
    }

    public ResponseEntity<ApiResponse<T>> createResponse() {
        return ResponseEntity.status(status).body(this);
    }
}
