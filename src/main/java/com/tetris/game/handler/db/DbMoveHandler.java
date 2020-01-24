package com.tetris.game.handler.db;

import com.tetris.game.handler.MoveEventType;
import com.tetris.game.handler.MoveHandler;
import com.tetris.game.handler.user.UserMoveHandler;

public class DbMoveHandler implements MoveHandler {

    private final UserMoveHandler userMoveHandler;
    private final int restoreGameId;

    public DbMoveHandler(int restoreGameId) {
        this.restoreGameId = restoreGameId;
        userMoveHandler = new UserMoveHandler(restoreGameId);
    }

    @Override
    public MoveEventType getNewMoveEvent() {
        return null;
    }
}
