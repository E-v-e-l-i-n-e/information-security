package com.evelina.lab1.models;

import jakarta.persistence.*;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class MusicBand {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    @Size(min = 1)
    private String name;

    @Column(nullable = false)
    @Min(1)
    private Long numberOfParticipants;

    @Min(1)
    private long singlesCount;

    @Min(1)
    private int albumsCount;
}