package com.tetris.model;

import java.util.Scanner;

public class Player {

    private final PlayerMoveEventPool moveEventPool = new PlayerMoveEventPool();

    public MoveEvent getNextMoveEvent() {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            String s = scanner.nextLine();
            if (moveEventPool.pool.get(s) != null) {
                return moveEventPool.pool.get(s);
            } else if (s.equals("x")) {
                System.out.println("GG WP Lox");
                System.exit(0);
            }
        }
    }
}
