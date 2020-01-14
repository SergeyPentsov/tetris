package com.tetris.builder;

import com.tetris.db.repositories.impl.FigureRepository;
import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor

public abstract class AbstractFigureBuilder implements FigureBuilder {
    final FigureRepository repository = new FigureRepository();

    @Getter
    private final int gameId;
}
