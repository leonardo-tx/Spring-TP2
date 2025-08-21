package com.crud.game.core.game.repository;

import com.crud.game.core.game.model.Game;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface GameRepository {
    List<Game> findAll();
    Optional<Game> findById(Long id);
    Game save(Game game);
    void delete(Game game);
}
