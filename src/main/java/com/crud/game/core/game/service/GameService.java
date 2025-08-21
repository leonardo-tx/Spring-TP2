package com.crud.game.core.game.service;

import com.crud.game.core.game.model.Game;

import java.util.List;

public interface GameService {
    List<Game> getAll();
    Game getByIdOrThrow(Long id);
    Game add(Game game);
    void delete(Game game);
    Game update(Game game);
}
