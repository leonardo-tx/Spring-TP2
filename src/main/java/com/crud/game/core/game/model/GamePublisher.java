package com.crud.game.core.game.model;

import com.crud.game.core.game.exception.publisher.GameInvalidLengthPublisherException;
import com.crud.game.core.game.exception.publisher.GameNullPublisherException;
import lombok.Getter;

@Getter
public final class GamePublisher {
    public static final int MIN_LENGTH = 2;
    public static final int MAX_LENGTH = 64;

    private final String value;

    private GamePublisher(String value) {

        this.value = value;
    }

    public static GamePublisher valueOf(String value) {
        if (value == null) {
            throw new GameNullPublisherException();
        }
        String valueSanitized = value.strip();
        if (valueSanitized.length() < MIN_LENGTH || valueSanitized.length() > MAX_LENGTH) {
            throw new GameInvalidLengthPublisherException(MIN_LENGTH, MAX_LENGTH);
        }
        return new GamePublisher(valueSanitized);
    }

    public static GamePublisher fromInfra(String value) {
        return new GamePublisher(value);
    }
}
