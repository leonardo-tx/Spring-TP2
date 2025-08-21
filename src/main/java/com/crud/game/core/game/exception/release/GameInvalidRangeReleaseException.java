package com.crud.game.core.game.exception.release;

import com.crud.game.core.generic.exception.ValidationException;

public class GameInvalidRangeReleaseException extends ValidationException {
    public GameInvalidRangeReleaseException(int minYear) {
        super("game.release.invalid.range", generateMessage(minYear));
    }

    private static String generateMessage(int minYear) {
        return String.format(
                "The release date must have a year equal or greater than %d and cannot exceed the current day.",
                minYear
        );
    }
}
