package com.crud.game.core.game.service;

import com.crud.game.core.game.exception.service.GameNotFoundException;
import com.crud.game.core.game.model.Game;
import com.crud.game.core.game.repository.GameRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class GameServiceImpl implements GameService {
    private final GameRepository gameRepository;

    @Override
    public List<Game> getAll() {
        return gameRepository.findAll();
    }

    @Override
    public Game getByIdOrThrow(Long id) {
        return gameRepository.findById(id).orElseThrow(GameNotFoundException::new);
    }

    @Override
    public Game add(Game game) {
        return gameRepository.save(game);
    }

    @Override
    public void delete(Game game) {
        if (game.getId() == null) {
            throw new IllegalArgumentException("Cannot pass a Game object without an id when deleting.");
        }
        gameRepository.delete(game);
    }

    @Override
    public Game update(Game game) {
        if (game.getId() == null) {
            throw new IllegalArgumentException("Cannot pass a Game object without an id when updating.");
        }
        if (gameRepository.findById(game.getId()).isEmpty()) {
            throw new GameNotFoundException();
        }
        return gameRepository.save(game);
    }
}
