package com.tetris;

import com.tetris.builder.FigureBuilderFactory;
import com.tetris.model.Board;

import java.util.Scanner;

import static com.tetris.builder.FigureBuilderFactory.BuilderType.TEST;

public class Application {
    public static void main(String[] args) {
        Board board = new Board(15, 10, new FigureBuilderFactory().getBuilder(TEST));
        board.doGame();
    }
}
