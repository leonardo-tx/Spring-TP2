package com.crud.game.api.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public final class ErrorData {
    private final String code;
    private final String message;
}
