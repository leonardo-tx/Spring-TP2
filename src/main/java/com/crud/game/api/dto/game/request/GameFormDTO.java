package com.crud.game.api.dto.game.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GameFormDTO {
    private String name;
    private String description;
    private String developer;
    private String publisher;
    private LocalDate release;
}
