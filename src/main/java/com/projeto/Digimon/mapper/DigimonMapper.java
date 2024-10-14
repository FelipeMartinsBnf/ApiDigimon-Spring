package com.projeto.Digimon.mapper;

import com.projeto.Digimon.dto.DigimonDto;
import com.projeto.Digimon.entity.Digimon;

public class DigimonMapper {

    public static DigimonDto mapToDigimonDto(Digimon digimon){
        return new DigimonDto(
                digimon.getId(),
                digimon.getName(),
                digimon.getImg(),
                digimon.getLevel()
        );
    }

    public static Digimon mapToDigimon(DigimonDto digimonDto){
        return new Digimon(
                digimonDto.getId(),
                digimonDto.getName(),
                digimonDto.getImg(),
                digimonDto.getLevel()
        );
    }
}
