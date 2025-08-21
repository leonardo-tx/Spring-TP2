package com.crud.game.api.dto.game.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GameViewDTO {
    private Long id;
    private String name;
    private String description;
    private String developer;
    private String publisher;
    private LocalDate release;
}
