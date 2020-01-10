package com.tetris;

import com.tetris.builder.FigureBuilderFactory;
import com.tetris.model.Board;
import lombok.extern.slf4j.Slf4j;

import java.util.Arrays;

import static com.tetris.builder.FigureBuilderFactory.BuilderType.TEST;


@Slf4j
public class Application {

    public static void main(String[] args) {
        log.info("Start tetris application {}", Arrays.toString(args));
        Board board = new Board(15, 10, new FigureBuilderFactory().getBuilder(TEST));
        board.doGame();
    }
}
