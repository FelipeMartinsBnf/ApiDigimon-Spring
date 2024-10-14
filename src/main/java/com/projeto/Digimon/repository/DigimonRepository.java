package com.projeto.Digimon.repository;

import com.projeto.Digimon.entity.Digimon;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface DigimonRepository extends JpaRepository<Digimon, Long> {
    List<Digimon> findByName(String name);
    List<Digimon> findByLevel(String level);
}
