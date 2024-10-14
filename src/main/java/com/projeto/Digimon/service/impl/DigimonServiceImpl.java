package com.projeto.Digimon.service.impl;

import com.projeto.Digimon.dto.DigimonDto;
import com.projeto.Digimon.entity.Digimon;
import com.projeto.Digimon.exception.ResourceNotFoundExeption;
import com.projeto.Digimon.mapper.DigimonMapper;
import com.projeto.Digimon.repository.DigimonRepository;
import com.projeto.Digimon.service.DigimonService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class DigimonServiceImpl implements DigimonService {

    private DigimonRepository digimonRepository;

    @Override
    public DigimonDto createDigimon(DigimonDto digimonDto) {
        Digimon digimon = DigimonMapper.mapToDigimon(digimonDto);
        Digimon savedDigimon = digimonRepository.save(digimon);
        return DigimonMapper.mapToDigimonDto(savedDigimon);
    }

    @Override
    public List<DigimonDto> createDigimons(List<DigimonDto> digimonsDto) {
        List<Digimon> digimons = digimonsDto.stream().map(DigimonMapper::mapToDigimon).toList();

        List<Digimon> savedDigimons = digimonRepository.saveAll(digimons);
        return savedDigimons.stream().map(DigimonMapper::mapToDigimonDto).toList();
    }

    @Override
    public List<DigimonDto> getAllDigimons() {
        List<Digimon> digimons = digimonRepository.findAll();
        return digimons.stream().map(DigimonMapper::mapToDigimonDto)
                .collect(Collectors.toList());

    }

    @Override
    public List<DigimonDto> getDigimonByName(String name) {
        List<Digimon> digimons = digimonRepository.findByName(name);
            if(digimons.isEmpty()) {
                throw new ResourceNotFoundExeption("Nenhum Digimon encontrado com o nome "+name);
            }
            return digimons.stream().map(DigimonMapper::mapToDigimonDto).toList();
    }

    @Override
    public List<DigimonDto> getDigimonByLevel(String level) {
        List<Digimon> digimons = digimonRepository.findByLevel(level);
        if (digimons.isEmpty()) {
            throw new ResourceNotFoundExeption("Nenhum Digimon encontrado com o level "+ level);
        }
        return digimons.stream().map(DigimonMapper::mapToDigimonDto).toList();
    }
}
