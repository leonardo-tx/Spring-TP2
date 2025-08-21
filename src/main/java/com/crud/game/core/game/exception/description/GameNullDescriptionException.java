package com.crud.game.core.game.exception.description;

import com.crud.game.core.generic.exception.ValidationException;

public class GameNullDescriptionException extends ValidationException {
    public GameNullDescriptionException() {
        super("game.description.null", "The game description cannot be null.");
    }
}
