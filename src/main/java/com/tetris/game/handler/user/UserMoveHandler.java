package com.tetris.game.handler.user;

import com.tetris.db.repositories.impl.MoveRepository;
import com.tetris.game.handler.MoveEventType;
import com.tetris.game.handler.MoveHandler;
import lombok.AllArgsConstructor;

import java.util.Scanner;

@AllArgsConstructor
public class UserMoveHandler implements MoveHandler {
    private final int gameId;
    private final PlayerMoveEventPool moveEventPool = new PlayerMoveEventPool();
    private final MoveRepository moveRepository = new MoveRepository();

    @Override
    public MoveEventType getNewMoveEvent() {
        Scanner scanner = new Scanner(System.in);
        MoveEventType event;
        do {
            event = moveEventPool.pool.get(scanner.nextLine());
            moveRepository.sameNewMoveEvent(gameId);
        } while (event == null);
        return event;
    }
}
