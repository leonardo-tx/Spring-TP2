package com.crud.game.infra.game.repository;

import com.crud.game.infra.game.persistence.GameEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GameRepositoryJPA extends JpaRepository<GameEntity, Long> {
}
