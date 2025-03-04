package com.projeto.Digimon.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class DigimonDto {
    private Long id;
    private String name;
    private String img;
    private String level;
}
