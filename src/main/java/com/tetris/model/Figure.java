package com.tetris.model;

import com.tetris.model.MoveEvent.MoveEventType;
import lombok.Builder;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;

import java.util.List;
import java.util.stream.Collectors;

import static com.tetris.model.MoveEvent.MoveEventType.LEFT_ROTATE;
import static com.tetris.model.MoveEvent.MoveEventType.RIGHT_ROTATE;


@Data
@Builder
@Slf4j
public class Figure {

    private final List<Point> points;
    private final Point pivot;
    private final Point currentCoordinateOnBoard;


    public Figure getNewFigureByMoveEventType(MoveEventType eventType) {
        return eventType == LEFT_ROTATE || eventType == RIGHT_ROTATE ? rotate(eventType) : move(eventType);
    }

    private Figure move(MoveEventType eventType) {
        log.debug("Figure move event {}",eventType);
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
        log.debug("Figure rotate event {}", eventType);
        if (eventType == LEFT_ROTATE) {
            return new Figure(points.stream()
                    .map(point -> new Point(getPointByPivot(point).getY() * -1, getPointByPivot(point).getX()))
                    .collect(Collectors.toList()), pivot, currentCoordinateOnBoard);
        }
        if (eventType == RIGHT_ROTATE) {
            return new Figure(points.stream()
                    .map(point -> new Point(getPointByPivot(point).getY(), getPointByPivot(point).getX() * -1))
                    .collect(Collectors.toList()), pivot, currentCoordinateOnBoard);
        }

        throw new IllegalArgumentException("Invalid rotate state");
    }

    public List<Point> getPointsByBoardCoordinates() {
        return points.stream().map(point -> new Point(point.getX() + currentCoordinateOnBoard.getX(),
                point.getY() + currentCoordinateOnBoard.getY())).collect(Collectors.toList());
    }


    private Point getPointByPivot(Point point) {
        return new Point(point.getX() - pivot.getX(), point.getY() - pivot.getY());
    }

}
