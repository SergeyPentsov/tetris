package com.tetris.builder;

import com.tetris.model.Figure;
import com.tetris.model.Point;

public interface FigureBuilder {

    Figure next(Point boardStartPoint);
}
