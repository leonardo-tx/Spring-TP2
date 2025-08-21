package com.crud.game.core.game.exception.publisher;

import com.crud.game.core.generic.exception.ValidationException;

public class GameInvalidLengthPublisherException extends ValidationException {
    public GameInvalidLengthPublisherException(int min, int max) {
        super("game.publisher.invalid.length", generateMessage(min, max));
    }

    private static String generateMessage(int min, int max) {
        return String.format(
                "The number of characters in the game publisher must be equal to or greater than %d and less than or equal to %d",
                min,
                max
        );
    }
}
