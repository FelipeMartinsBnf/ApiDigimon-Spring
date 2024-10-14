// endpoints da API
package com.projeto.Digimon.controller;

import com.projeto.Digimon.dto.DigimonDto;
import com.projeto.Digimon.service.DigimonService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import lombok.AllArgsConstructor;
import org.apache.catalina.connector.Response;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("/api/digimon")
public class DigimonContainer {

    private DigimonService digimonService;

    // Criando a rota para Adicionar
    @PostMapping
    @Operation(description = "Adicionar um Digimon")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Adiciona o Digimon ao Banco de Dados"),
            @ApiResponse(responseCode = "400", description = "Erro ao adiocionar")
    })
    public ResponseEntity<DigimonDto> createDigimon(
            @Parameter(description = "Objeto Digimon a ser adicionado")@RequestBody DigimonDto digimonDto){
        DigimonDto savedDigimon = digimonService.createDigimon(digimonDto);
        return new ResponseEntity<>(savedDigimon, HttpStatus.CREATED);
    }

    //Criando a rota para Adicionar vários Digimons usando um array
    //Fiz assim para facilitar adicionar o array que foi disponibilizado
    @Operation(description = "Adicionar vários Digimon em uma lista")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Adiciona todos Digimon ao Banco de Dados"),
            @ApiResponse(responseCode = "400", description = "Erro ao adiocionar")
    })
    @PostMapping("/bulk")
    public ResponseEntity<List<DigimonDto>> createDigimons(
            @Parameter(description = "Array de Digions a ser adicionado")@RequestBody List<DigimonDto> digimonsDto) {
        List<DigimonDto> savesDigimons = digimonService.createDigimons(digimonsDto);
        return new ResponseEntity<>(savesDigimons, HttpStatus.CREATED);
    }


    // Mostrar Todos
    @GetMapping
    @Operation(description = "Retorna todos os digimons")
    @ApiResponse(responseCode = "200", description = "Retorna todos os digimons")
    public ResponseEntity<List<DigimonDto>> getAllDigimons(){
        List<DigimonDto> digimons = digimonService.getAllDigimons();
        return  ResponseEntity.ok(digimons);
    }

    //Fazendo get by name
    @GetMapping("/procurar")
    @Operation(description = "Procurar Digimon usando o Nome")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Retorna um Digimon com o nome especificado"),
            @ApiResponse(responseCode = "404", description = "Não existe nenhum digimon com esse nome")
    })
    public List<DigimonDto> getDigimonByName(
            @Parameter(description = "Nome do Digimon a ser procurado") @RequestParam String name){
        return digimonService.getDigimonByName(name);
    }

    //Fazendo o get por level
    @Operation(description = "Procurar Digimon usando o seu level")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Retorna um Digimon com o level especificado"),
            @ApiResponse(responseCode = "404", description = "Não existe nenhum digimon com esse level")
    })
    @GetMapping("/level")
    public List<DigimonDto> getDigimonByLevel(
            @Parameter(description = "Level do Digimon a ser procurado")@RequestParam String level){
        return digimonService.getDigimonByLevel(level);
    }
}
