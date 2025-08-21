package com.crud.game.core.game.model;

import com.crud.game.core.game.exception.developer.GameInvalidLengthDeveloperException;
import com.crud.game.core.game.exception.developer.GameNullDeveloperException;
import lombok.EqualsAndHashCode;
import lombok.Getter;

@Getter
@EqualsAndHashCode
public final class GameDeveloper {
    public static final int MIN_LENGTH = 2;
    public static final int MAX_LENGTH = 64;

    private final String value;

    private GameDeveloper(String value) {
        this.value = value;
    }

    public static GameDeveloper valueOf(String value) {
        if (value == null) {
            throw new GameNullDeveloperException();
        }
        String valueSanitized = value.strip();
        if (valueSanitized.length() < MIN_LENGTH || valueSanitized.length() > MAX_LENGTH) {
            throw new GameInvalidLengthDeveloperException(MIN_LENGTH, MAX_LENGTH);
        }
        return new GameDeveloper(valueSanitized);
    }

    public static GameDeveloper fromInfra(String value) {
        return new GameDeveloper(value);
    }
}
