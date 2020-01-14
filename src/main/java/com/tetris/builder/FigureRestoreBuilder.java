package com.tetris.builder;

import com.tetris.game.Figure;
import com.tetris.model.Point;
import sun.reflect.generics.reflectiveObjects.NotImplementedException;

public class FigureRestoreBuilder extends AbstractFigureBuilder {
    private final FigureBuilder builder;

    public FigureRestoreBuilder(int gameId, FigureBuilder builder) {
        super(gameId);
        this.builder = builder;
    }


    @Override
    public Figure next(Point boardStartPoint) {
        throw new NotImplementedException();
    }
}
