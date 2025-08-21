package com.crud.game.core.game.factory;

import com.crud.game.core.game.model.Game;

import java.time.LocalDate;

public interface GameFactory {
    Game create(Long id, String name, String description, String developer, String publisher, LocalDate release);
    Game create(String name, String description, String developer, String publisher, LocalDate release);
}
