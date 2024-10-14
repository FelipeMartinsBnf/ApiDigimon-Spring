package com.projeto.Digimon.service;

import com.projeto.Digimon.dto.DigimonDto;

import java.util.List;

public interface DigimonService {
    DigimonDto createDigimon(DigimonDto digimonDto);

    List<DigimonDto> createDigimons(List<DigimonDto> digimonsDto);

    List<DigimonDto> getAllDigimons();

    List<DigimonDto> getDigimonByName(String name);

    List<DigimonDto> getDigimonByLevel(String level);
}
