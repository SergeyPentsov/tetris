package com.tetris.db.repositories.impl;

import com.tetris.db.repositories.Repository;

import java.util.Optional;

public class GameRepository implements Repository {


    public Optional<Integer> getActiveGameId() {
        return Optional.empty();
    }

    public int createNewGame() {
        return 0;
    }

    public void finishGame(int gameId) {

    }

}
