package com.crud.game.core.game.exception.publisher;

import com.crud.game.core.generic.exception.ValidationException;

public class GameNullPublisherException extends ValidationException {
    public GameNullPublisherException() {
        super("game.publisher.null", "The game publisher cannot be null.");
    }
}
