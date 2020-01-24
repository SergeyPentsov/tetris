package com.tetris.db.entity;


import com.tetris.game.handler.MoveEventType;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table
@Data
@NoArgsConstructor
public class Move {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "move_id")
    private int moveId;

    @Column(name = "move_event_type")
    @Enumerated(EnumType.STRING)
    private MoveEventType moveEventType;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "game_id", nullable = false, unique = true)
    private Game game;


}

