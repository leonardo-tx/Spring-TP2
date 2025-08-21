package com.crud.game.core.game.exception.description;

import com.crud.game.core.generic.exception.ValidationException;

public class GameInvalidLengthDescriptionException extends ValidationException {
    public GameInvalidLengthDescriptionException(int max) {
        super("game.description.invalid.length", generateMessage(max));
    }

    private static String generateMessage(int max) {
        return String.format("The number of characters in the game description must be less than or equal to %d", max);
    }
}
