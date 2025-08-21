package com.crud.game.core.game.exception.release;

import com.crud.game.core.generic.exception.ValidationException;

public class GameNullReleaseException extends ValidationException {
    public GameNullReleaseException() {
        super("game.release.null", "The game release cannot be null.");
    }
}
