package com.tetris;

import com.tetris.db.ConnectionFactory;
import com.tetris.game.GameBuilder;
import lombok.extern.slf4j.Slf4j;

import java.util.Arrays;


@Slf4j
public class Application {

    public static void main(String[] args) {
        ConnectionFactory.sessionFactory.openSession();
        log.info("Start tetris application {}", Arrays.toString(args));
        GameBuilder.build().start();
    }
}
