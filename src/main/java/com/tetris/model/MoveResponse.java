package com.tetris.model;

public class MoveResponse {
    private final MoveResponseType responseType;

    public MoveResponse(MoveResponseType responseType) {
        this.responseType = responseType;
    }

    public enum MoveResponseType {
        VALID,
        INVALID,
        NEXT_FIGURE,
        END_GAME,
    }
}
