package com.crud.game.core.game.factory;

import com.crud.game.core.game.model.*;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

@Component
public class GameFactoryImpl implements GameFactory {
    @Override
    public Game create(Long id, String name, String description, String developer, String publisher, LocalDate release) {
        GameName gameName = GameName.valueOf(name);
        GameDescription gameDescription = GameDescription.valueOf(description);
        GameDeveloper gameDeveloper = GameDeveloper.valueOf(developer);
        GamePublisher gamePublisher = GamePublisher.valueOf(publisher);
        GameRelease gameRelease = GameRelease.valueOf(release);

        return new Game(id, gameName, gameDescription, gameDeveloper, gamePublisher, gameRelease);
    }

    @Override
    public Game create(String name, String description, String developer, String publisher, LocalDate release) {
        return create(null, name, description, developer, publisher, release);
    }
}
