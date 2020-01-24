package com.tetris.game;

import com.tetris.game.handler.MoveHandler;
import com.tetris.model.GameState;
import lombok.AllArgsConstructor;

import static com.tetris.model.GameState.ACTIVE;

@AllArgsConstructor
public class Game {

    private final MoveHandler moveHandler;
    private final Board board;

    public void start() {
        GameState state = ACTIVE;
        while (state == ACTIVE) {
            state = board.doGame(moveHandler.getNewMoveEvent());
        }
    }
}
