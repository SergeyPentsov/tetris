package com.tetris.db.entity;


import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "figure_type")
@Data
@NoArgsConstructor
public class FigureType {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "figure_type_id")
    private int figureTypeId;

    @Column(name = "figure_structure")
    private String figureStructure;

    @ManyToMany(cascade = {CascadeType.ALL})
    @JoinTable(
            name = "figure",
            joinColumns = {@JoinColumn(name = "figure_type_id")},
            inverseJoinColumns = {@JoinColumn(name = "game_id")}
    )
    private List<Game> games;

}
