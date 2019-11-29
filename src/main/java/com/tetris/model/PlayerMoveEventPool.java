package com.tetris.model;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

import static com.tetris.model.MoveEvent.MoveEventType.*;

public class PlayerMoveEventPool {
    public final Map<String, MoveEvent> pool;

    public PlayerMoveEventPool() {
        Map<String, MoveEvent> pool = new HashMap<>();
        pool.put("a", new MoveEvent(MOVE_LEFT));
        pool.put("s", new MoveEvent(MOVE_DOWN));
        pool.put("d", new MoveEvent(MOVE_RIGHT));
        pool.put("q", new MoveEvent(LEFT_ROTATE));
        pool.put("e", new MoveEvent(RIGHT_ROTATE));
        this.pool = Collections.unmodifiableMap(pool);
    }
}
