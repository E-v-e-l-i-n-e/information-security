package com.evelina.lab1.service;


import com.evelina.lab1.models.MusicBand;
import com.evelina.lab1.repository.MusicBandRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class MusicBandService {
    private final MusicBandRepository musicBandRepository;

    public List<MusicBand> findAll() {
        return musicBandRepository.findAll();
    }

    public MusicBand create(MusicBand musicBand) {
        return musicBandRepository.save(musicBand);
    }
}
