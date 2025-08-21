package com.crud.game.api.controller;

import com.crud.game.api.dto.ApiResponse;
import com.crud.game.api.dto.game.mapper.GameApiMapper;
import com.crud.game.api.dto.game.request.GameFormDTO;
import com.crud.game.api.dto.game.response.GameViewDTO;
import com.crud.game.core.game.model.Game;
import com.crud.game.core.game.service.GameService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/game")
public class GameController {
    private final GameApiMapper mapper;
    private final GameService gameService;

    @GetMapping
    public ResponseEntity<ApiResponse<List<GameViewDTO>>> getAll() {
        List<GameViewDTO> gameViewDTOs = gameService.getAll()
                .stream()
                .map(mapper::toView)
                .toList();
        return ApiResponse.success(HttpStatus.OK, gameViewDTOs).createResponse();
    }

    @GetMapping("/{id}")
    public ResponseEntity<ApiResponse<GameViewDTO>> getById(@PathVariable("id") Long id) {
        Game game = gameService.getByIdOrThrow(id);
        GameViewDTO gameViewDTO = mapper.toView(game);
        return ApiResponse.success(HttpStatus.OK, gameViewDTO).createResponse();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<ApiResponse<Object>> deleteById(@PathVariable("id") Long id) {
        Game game = gameService.getByIdOrThrow(id);
        gameService.delete(game);

        return ApiResponse.success(HttpStatus.OK, null).createResponse();
    }

    @PostMapping
    public ResponseEntity<ApiResponse<GameViewDTO>> addGame(@RequestBody GameFormDTO form) {
        Game game = mapper.toGame(form);
        Game createdGame = gameService.add(game);
        GameViewDTO gameViewDTO = mapper.toView(createdGame);

        return ApiResponse.success(HttpStatus.CREATED, gameViewDTO).createResponse();
    }

    @PutMapping("/{id}")
    public ResponseEntity<ApiResponse<GameViewDTO>> updateOrAddGame(
            @PathVariable("id") Long id,
            @RequestBody GameFormDTO form
    ) {
        Game game = mapper.toGame(form, id);
        Game updatedGame = gameService.update(game);
        GameViewDTO gameViewDTO = mapper.toView(updatedGame);

        return ApiResponse.success(HttpStatus.OK, gameViewDTO).createResponse();
    }
}
