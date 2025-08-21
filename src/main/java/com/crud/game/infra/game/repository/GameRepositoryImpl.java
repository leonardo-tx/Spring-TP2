package com.crud.game.infra.game.repository;

import com.crud.game.core.game.model.Game;
import com.crud.game.core.game.repository.GameRepository;
import com.crud.game.infra.game.mapper.GameInfraMapper;
import com.crud.game.infra.game.persistence.GameEntity;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
@RequiredArgsConstructor
public class GameRepositoryImpl implements GameRepository {
    private final GameRepositoryJPA gameRepositoryJPA;
    private final GameInfraMapper mapper;

    @Override
    public List<Game> findAll() {
        return gameRepositoryJPA.findAll()
                .stream()
                .map(mapper::toModel)
                .toList();
    }

    @Override
    public Optional<Game> findById(Long id) {
        return gameRepositoryJPA.findById(id).map(mapper::toModel);
    }

    @Override
    public Game save(Game game) {
        GameEntity entityToSave = mapper.toEntity(game);
        GameEntity savedEntity = gameRepositoryJPA.save(entityToSave);
        return mapper.toModel(savedEntity);
    }

    @Override
    public void delete(Game game) {
        gameRepositoryJPA.deleteById(game.getId());
    }
}
