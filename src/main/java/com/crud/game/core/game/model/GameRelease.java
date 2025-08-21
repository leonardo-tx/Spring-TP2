package com.crud.game.core.game.model;

import com.crud.game.core.game.exception.release.GameInvalidRangeReleaseException;
import com.crud.game.core.game.exception.release.GameNullReleaseException;
import lombok.Getter;

import java.time.LocalDate;
import java.time.ZoneOffset;

@Getter
public final class GameRelease {
    public static final int MIN_YEAR = 1950;

    private final LocalDate value;

    private GameRelease(LocalDate value) {
        this.value = value;
    }

    public static GameRelease valueOf(LocalDate value) {
        if (value == null) {
            throw new GameNullReleaseException();
        }
        LocalDate now = LocalDate.now(ZoneOffset.UTC);
        if (value.getYear() < MIN_YEAR || value.isAfter(now)) {
            throw new GameInvalidRangeReleaseException(MIN_YEAR);
        }
        return new GameRelease(value);
    }

    public static GameRelease fromInfra(LocalDate value) {
        return new GameRelease(value);
    }
}
