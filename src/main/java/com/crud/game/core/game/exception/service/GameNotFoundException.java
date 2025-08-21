package com.crud.game.core.game.exception.service;

import com.crud.game.core.generic.exception.NotFoundException;

public class GameNotFoundException extends NotFoundException {
    public GameNotFoundException() {
        super("game.not.found", "Could not find a game with the given argument.");
    }
}
