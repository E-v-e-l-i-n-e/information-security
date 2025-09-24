package com.evelina.lab1.repository;

import com.evelina.lab1.models.MusicBand;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MusicBandRepository extends JpaRepository<MusicBand, Integer> {

}