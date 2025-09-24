package com.evelina.lab1.controller;

import com.evelina.lab1.models.MusicBand;
import com.evelina.lab1.service.HtmlSanitizerService;
import com.evelina.lab1.service.MusicBandService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/api/music-bands")
@RequiredArgsConstructor
public class MusicBandController {

    private final MusicBandService musicBandService;
    private final HtmlSanitizerService sanitizerService;

    @GetMapping("/data")
    public List<MusicBand> getAllMusicBands() {
        return musicBandService.findAll();
    }

    @PostMapping
    public MusicBand createMusicBand(@RequestBody MusicBand musicBand) {
        String originalName = musicBand.getName();
        String sanitizedName = sanitizerService.sanitize(originalName);
        musicBand.setName(sanitizedName);
        return musicBandService.create(musicBand);
    }
}