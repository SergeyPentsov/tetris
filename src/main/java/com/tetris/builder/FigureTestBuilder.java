package com.tetris.builder;

import com.tetris.model.Figure;
import com.tetris.model.Point;

import java.util.ArrayList;
import java.util.List;

public class FigureTestBuilder implements FigureBuilder {
    @Override
    public Figure next(Point boardStartPoint) {
        List<Point> testFigurePoints = new ArrayList<>();
        testFigurePoints.add(new Point(0, 0));
        testFigurePoints.add(new Point(1, 0));
        testFigurePoints.add(new Point(1, 1));
        testFigurePoints.add(new Point(2, 1));
        return Figure.builder()
                .points(testFigurePoints)
                .pivot(new Point(1, 1))
                .currentCoordinateOnBoard(new Point(boardStartPoint.getX(), boardStartPoint.getY() + 1))
                .build();
    }
}
