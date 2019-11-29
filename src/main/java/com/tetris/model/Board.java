package com.tetris.model;

import com.tetris.builder.FigureBuilder;

import java.util.ArrayList;
import java.util.List;

import static com.tetris.model.MoveEvent.MoveEventType.MOVE_DOWN;

public class Board {
    private final int height;
    private final int width;
    private final List<Point> fillPoints = new ArrayList<>();
    private Figure activeFigure;
    private final FigureBuilder figureBuilder;
    private final Player player;
    private final Point startFigurePoint;

    public Board(int height, int width, FigureBuilder figureBuilder) {
        this.height = height;
        this.width = width;
        this.figureBuilder = figureBuilder;
        this.startFigurePoint = new Point(width / 2, 0);
        this.activeFigure = figureBuilder.next(startFigurePoint);
        this.player = new Player();
    }

    public void doGame() {
        while (true) {
            System.out.println(getStringState());
            System.out.println("----------------------------------------------------------------------");
            MoveEvent moveEvent = player.getNextMoveEvent();
            Figure nextFigure = activeFigure.getNewFigureByMoveEventType(moveEvent.getType());

            if (isValidFigureCoordinates(nextFigure) && !isValidFigurePoints(nextFigure) && moveEvent.getType() == MOVE_DOWN) {
                addFigurePointsToFillPoints(activeFigure);
                activeFigure = figureBuilder.next(startFigurePoint);
                continue;
            }
            if (!isValidFigureCoordinates(nextFigure) || !isValidFigurePoints(nextFigure)) {
                continue;
            }
            activeFigure = nextFigure;
        }

    }


    // TODO: 11/26/2019 rename
    public boolean isValidFigurePoints(Figure figure) {
        for (Point point : figure.getPointsByBoardCoordinates()) {
            if (fillPoints.contains(point)) {
                return false;
            }
        }
        return true;
    }

    // TODO: 11/26/2019 rename
    public boolean isValidFigureCoordinates(Figure figure) {
        for (Point point : figure.getPointsByBoardCoordinates()) {
            if (point.getX() < 0 || point.getX() > width || point.getY() > height) return false;
        }
        return true;
    }

    public void addFigurePointsToFillPoints(Figure figure) {
        fillPoints.addAll(figure.getPointsByBoardCoordinates());
    }


    public String getStringState() {
        char[][] charBoard = new char[height][width];
        fillPoints.forEach(point -> charBoard[point.getX()][point.getY()] = '#');
        activeFigure.getPointsByBoardCoordinates().forEach(point -> charBoard[point.getY()][point.getX()] = '*');
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < height; i++) {
            builder.append('-');
        }
        builder.append('\n');
        for (char[] chars : charBoard) {
            builder.append('|');
            for (char character : chars) {
                builder.append(character);
            }
            builder.append('|');
            builder.append('\n');
        }
        for (int i = 0; i < height; i++) {
            builder.append('-');
        }
        return builder.toString();
    }
}
