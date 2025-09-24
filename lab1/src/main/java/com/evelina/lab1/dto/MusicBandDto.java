package com.evelina.lab1.dto;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@RequiredArgsConstructor
public class MusicBandDto {
    @NotNull
    @Size(min = 1)
    private String name;

    @NotNull
    @Min(1)
    private Long numberOfParticipants;

    @Min(1)
    private long singlesCount;

    @Min(1)
    private int albumsCount;
}
