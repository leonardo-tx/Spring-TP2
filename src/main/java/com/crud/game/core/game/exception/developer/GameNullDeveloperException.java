package com.crud.game.core.game.exception.developer;

import com.crud.game.core.generic.exception.ValidationException;

public class GameNullDeveloperException extends ValidationException {
    public GameNullDeveloperException() {
        super("game.developer.null", "The game developer cannot be null.");
    }
}
