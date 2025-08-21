package com.crud.game.core.game.model;

import lombok.Getter;

import java.util.Objects;

@Getter
public final class Game implements Cloneable {
    private final Long id;
    private final GameName name;
    private final GameDescription description;
    private final GameDeveloper developer;
    private final GamePublisher publisher;
    private final GameRelease release;

    public Game(
            Long id,
            GameName name,
            GameDescription description,
            GameDeveloper developer,
            GamePublisher publisher,
            GameRelease release
    ) {
        this.id = id;
        this.name = Objects.requireNonNull(name, "The name cannot be null");
        this.description = Objects.requireNonNull(description, "The description cannot be null");
        this.developer = Objects.requireNonNull(developer, "The developer cannot be null");
        this.publisher = Objects.requireNonNull(publisher, "The publisher cannot be null");
        this.release = Objects.requireNonNull(release, "The release cannot be null");
    }

    @Override
    protected Object clone() throws CloneNotSupportedException
    {
        return super.clone();
    }
}
