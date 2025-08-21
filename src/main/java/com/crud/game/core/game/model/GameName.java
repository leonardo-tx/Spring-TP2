package com.crud.game.core.game.model;

import com.crud.game.core.game.exception.name.GameNullNameException;
import com.crud.game.core.game.exception.name.GameInvalidLengthNameException;
import lombok.EqualsAndHashCode;
import lombok.Getter;

@Getter
@EqualsAndHashCode
public final class GameName {
    public static final int MIN_LENGTH = 2;
    public static final int MAX_LENGTH = 128;

    private final String value;

    private GameName(String value) {
        this.value = value;
    }

    public static GameName valueOf(String value) {
        if (value == null) {
            throw new GameNullNameException();
        }
        String valueSanitized = value.strip();
        if (valueSanitized.length() < MIN_LENGTH || valueSanitized.length() > MAX_LENGTH) {
            throw new GameInvalidLengthNameException(MIN_LENGTH, MAX_LENGTH);
        }
        return new GameName(valueSanitized);
    }

    public static GameName fromInfra(String value) {
        return new GameName(value);
    }
}
