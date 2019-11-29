package com.tetris.model;

import com.tetris.model.MoveEvent.MoveEventType;

import java.util.ArrayList;
import java.util.List;

import static com.tetris.model.MoveEvent.MoveEventType.*;

public class Figure {

    private final List<Point> points;
    private final Point pivot;
    private final Point currentCoordinateOnBoard;

    private Figure(List<Point> points, Point pivot, Point currentCoordinatesOnBoard) {
        this.points = points;
        this.pivot = pivot;
        this.currentCoordinateOnBoard = currentCoordinatesOnBoard;
    }


    public Figure getNewFigureByMoveEventType(MoveEventType eventType) {
        return eventType == LEFT_ROTATE || eventType == RIGHT_ROTATE ? rotate(eventType) : move(eventType);
    }

    private Figure move(MoveEventType eventType) {
        Point newCoordinateOnBoard;
        switch (eventType) {
            case MOVE_RIGHT: {
                newCoordinateOnBoard = new Point(currentCoordinateOnBoard.getX() + 1,
                        currentCoordinateOnBoard.getY());
                break;
            }
            case MOVE_LEFT: {
                newCoordinateOnBoard = new Point(currentCoordinateOnBoard.getX() - 1,
                        currentCoordinateOnBoard.getY());
                break;
            }
            case MOVE_DOWN: {
                newCoordinateOnBoard = new Point(currentCoordinateOnBoard.getX(),
                        currentCoordinateOnBoard.getY() + 1);
                break;
            }
            default:
                throw new IllegalArgumentException("Invalid rotate state");
        }
        return new Figure(points, pivot, newCoordinateOnBoard);
    }

    private Figure rotate(MoveEventType eventType) {
        if (eventType == LEFT_ROTATE) {
            List<Point> newPoints = new ArrayList<>();
            for (Point point : points) {
                newPoints.add(new Point(getPointByPivot(point).getY() * -1, getPointByPivot(point).getX()));
            }
            return new Figure(newPoints, pivot, currentCoordinateOnBoard);
        }
        if (eventType == RIGHT_ROTATE) {
            List<Point> newPoints = new ArrayList<>();
            for (Point point : points) {
                newPoints.add(new Point(getPointByPivot(point).getY(), getPointByPivot(point).getX() * -1));
            }
            return new Figure(newPoints, pivot, currentCoordinateOnBoard);
        }

        throw new IllegalArgumentException("Invalid rotate state");
    }

    public List<Point> getPointsByBoardCoordinates() {
        List<Point> list = new ArrayList<>();
        for (Point point : points) {
            list.add(
                    new Point(point.getX() + currentCoordinateOnBoard.getX(),
                            point.getY() + currentCoordinateOnBoard.getY())
            );
        }
        return list;
    }


    private Point getPointByPivot(Point point) {
        return new Point(point.getX() - pivot.getX(), point.getY() - pivot.getY());
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Figure figure = (Figure) o;

        if (!points.equals(figure.points)) return false;
        if (!pivot.equals(figure.pivot)) return false;
        return currentCoordinateOnBoard.equals(figure.currentCoordinateOnBoard);
    }


    @Override
    public int hashCode() {
        int result = points.hashCode();
        result = 31 * result + pivot.hashCode();
        result = 31 * result + currentCoordinateOnBoard.hashCode();
        return result;
    }

    @Override
    public String toString() {
        return "Figure{" +
                "points=" + points +
                ", pivot=" + pivot +
                ", currentCoordinatesOnBoard=" + currentCoordinateOnBoard +
                '}';
    }

    public static class Builder {
        private List<Point> points;
        private Point pivot;
        private Point currentCoordinatesOnBoard;

        public Builder figure(Figure figure) {
            this.points = figure.points;
            this.pivot = figure.pivot;
            this.currentCoordinatesOnBoard = figure.currentCoordinateOnBoard;
            return this;
        }

        public Builder points(List<Point> points) {
            this.points = points;
            return this;
        }

        public Builder pivot(Point pivot) {
            this.pivot = pivot;
            return this;
        }

        public Builder currentCoordinatesOnBoard(Point currentCoordinatesOnBoard) {
            this.currentCoordinatesOnBoard = currentCoordinatesOnBoard;
            return this;
        }

        public Figure build() {
            return new Figure(points, pivot, currentCoordinatesOnBoard);
        }
    }

}
