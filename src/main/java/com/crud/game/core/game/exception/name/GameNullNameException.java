package com.crud.game.core.game.exception.name;

import com.crud.game.core.generic.exception.ValidationException;

public class GameNullNameException extends ValidationException {
    public GameNullNameException() {
        super("game.name.null", "The game name cannot be null.");
    }
}
