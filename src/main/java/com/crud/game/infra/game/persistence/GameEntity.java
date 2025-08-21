package com.crud.game.infra.game.persistence;

import com.crud.game.core.game.model.GameDescription;
import com.crud.game.core.game.model.GameDeveloper;
import com.crud.game.core.game.model.GameName;
import com.crud.game.core.game.model.GamePublisher;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;

@Entity
@Table(name = "TB_GAME")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class GameEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name", nullable = false, length = GameName.MAX_LENGTH)
    private String name;

    @Column(name = "description", nullable = false, length = GameDescription.MAX_LENGTH)
    private String description;

    @Column(name = "developer", nullable = false, length = GameDeveloper.MAX_LENGTH)
    private String developer;

    @Column(name = "publisher", nullable = false, length = GamePublisher.MAX_LENGTH)
    private String publisher;

    @Column(name = "release", nullable = false)
    private LocalDate release;
}
