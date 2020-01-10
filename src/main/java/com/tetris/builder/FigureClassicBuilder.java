package com.tetris.builder;

import com.tetris.model.Figure;
import com.tetris.model.Point;
import sun.reflect.generics.reflectiveObjects.NotImplementedException;

public class FigureClassicBuilder implements FigureBuilder {
    @Override
    public Figure next(Point boardStartPoint) {
        throw new NotImplementedException();
    }
}
