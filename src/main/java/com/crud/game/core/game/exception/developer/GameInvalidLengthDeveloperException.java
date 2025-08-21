package com.crud.game.core.game.exception.developer;

import com.crud.game.core.generic.exception.ValidationException;

public class GameInvalidLengthDeveloperException extends ValidationException {
    public GameInvalidLengthDeveloperException(int min, int max) {
        super("game.developer.invalid.length", generateMessage(min, max));
    }

    private static String generateMessage(int min, int max) {
        return String.format(
                "The number of characters in the game developer must be equal to or greater than %d and less than or equal to %d",
                min,
                max
        );
    }
}
