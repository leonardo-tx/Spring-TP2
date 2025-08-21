package com.crud.game.core.game.model;

import com.crud.game.core.game.exception.description.GameInvalidLengthDescriptionException;
import com.crud.game.core.game.exception.description.GameNullDescriptionException;
import lombok.EqualsAndHashCode;
import lombok.Getter;

@Getter
@EqualsAndHashCode
public final class GameDescription {
    public static final int MAX_LENGTH = 512;

    private final String value;

    private GameDescription(String value) {
        this.value = value;
    }

    public static GameDescription valueOf(String value) {
        if (value == null) {
            throw new GameNullDescriptionException();
        }
        String valueSanitized = value.strip();
        if (valueSanitized.length() > MAX_LENGTH) {
            throw new GameInvalidLengthDescriptionException(MAX_LENGTH);
        }
        return new GameDescription(valueSanitized);
    }

    public static GameDescription fromInfra(String value) {
        return new GameDescription(value);
    }
}
