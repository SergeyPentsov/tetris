package com.tetris.builder;

public class FigureBuilderFactory {


    public FigureBuilder getClassicBuilder(int gameId) {
        return new FigureClassicBuilder(gameId);
    }

    public FigureBuilder getRestoreBuilder(int gameId) {
        return new FigureRestoreBuilder(gameId, new FigureClassicBuilder(gameId));
    }
}
