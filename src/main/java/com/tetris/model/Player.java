package com.tetris.model;

import java.util.Optional;
import java.util.Scanner;

public class Player {

    private final PlayerMoveEventPool moveEventPool = new PlayerMoveEventPool();

    public Optional<MoveEvent> getNextMoveEvent() {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            return Optional.of(moveEventPool.pool.get(scanner.nextLine()));
        }
    }
}
