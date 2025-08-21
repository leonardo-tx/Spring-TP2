package com.crud.game.api.dto.game.mapper;

import com.crud.game.api.dto.game.request.GameFormDTO;
import com.crud.game.api.dto.game.response.GameViewDTO;
import com.crud.game.core.game.factory.GameFactory;
import com.crud.game.core.game.model.Game;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class GameApiMapper {
    private final GameFactory gameFactory;

    public Game toGame(GameFormDTO form) {
        return gameFactory.create(
                form.getName(),
                form.getDescription(),
                form.getDeveloper(),
                form.getPublisher(),
                form.getRelease()
        );
    }

    public Game toGame(GameFormDTO form, Long id) {
        return gameFactory.create(
                id,
                form.getName(),
                form.getDescription(),
                form.getDeveloper(),
                form.getPublisher(),
                form.getRelease()
        );
    }

    public GameViewDTO toView(Game game) {
        return new GameViewDTO(
                game.getId(),
                game.getName().getValue(),
                game.getDescription().getValue(),
                game.getDeveloper().getValue(),
                game.getPublisher().getValue(),
                game.getRelease().getValue()
        );
    }
}
