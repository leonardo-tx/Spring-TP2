package com.crud.game.core.game.exception.name;

import com.crud.game.core.generic.exception.ValidationException;

public class GameInvalidLengthNameException extends ValidationException {
    public GameInvalidLengthNameException(int min, int max) {
        super("game.name.invalid.length", generateMessage(min, max));
    }

    private static String generateMessage(int min, int max) {
        return String.format(
                "The number of characters in the game name must be equal to or greater than %d and less than or equal to %d",
                min,
                max
        );
    }
}
