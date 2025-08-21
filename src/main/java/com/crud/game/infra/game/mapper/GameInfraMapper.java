package com.crud.game.infra.game.mapper;

import com.crud.game.core.game.model.*;
import com.crud.game.infra.game.persistence.GameEntity;
import org.springframework.stereotype.Component;

@Component
public class GameInfraMapper {
    public Game toModel(GameEntity entity) {
        GameName gameName = GameName.fromInfra(entity.getName());
        GameDescription gameDescription = GameDescription.fromInfra(entity.getDescription());
        GameDeveloper gameDeveloper = GameDeveloper.fromInfra(entity.getDeveloper());
        GamePublisher gamePublisher = GamePublisher.fromInfra(entity.getPublisher());
        GameRelease gameRelease = GameRelease.fromInfra(entity.getRelease());

        return new Game(entity.getId(), gameName, gameDescription, gameDeveloper, gamePublisher, gameRelease);
    }

    public GameEntity toEntity(Game model) {
        return GameEntity.builder()
                .id(model.getId())
                .name(model.getName().getValue())
                .description(model.getDescription().getValue())
                .developer(model.getDeveloper().getValue())
                .publisher(model.getPublisher().getValue())
                .release(model.getRelease().getValue())
                .build();
    }
}
