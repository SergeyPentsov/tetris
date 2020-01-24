package com.tetris.builder;

import com.tetris.game.Figure;
import com.tetris.model.Point;
import sun.reflect.generics.reflectiveObjects.NotImplementedException;

public class FigureClassicBuilder extends AbstractFigureBuilder {

    public FigureClassicBuilder(int gameId) {
        super(gameId);
    }

    @Override
    public Figure next(Point boardStartPoint) {
        repository.saveNewFigure(getGameId(), 0);
        throw new NotImplementedException();
    }
}
