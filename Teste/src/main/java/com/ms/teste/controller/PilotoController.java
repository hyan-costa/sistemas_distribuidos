package com.ms.teste.controller;

import com.ms.teste.models.Piloto;
import com.ms.teste.services.PilotoService;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/pilotos")
public class PilotoController {

    @Autowired
    private PilotoService pilotoService;

    @Operation(summary = "Obter todos os pilotos")
    @GetMapping
    public List<Piloto> getAllPilotos() {
        return pilotoService.getAllPilotos();
    }

    @Operation(summary = "Obter um piloto pelo ID")
    @GetMapping("/{id}")
    public Piloto getPilotoById(@PathVariable Long id) {
        return pilotoService.getPilotoById(id);
    }

    @Operation(summary = "Criar um novo piloto")
    @PostMapping
    public Piloto createPiloto(@RequestBody Piloto piloto) {
        return pilotoService.savePiloto(piloto);
    }

    @Operation(summary = "Deletar um piloto pelo ID")
    @DeleteMapping("/{id}")
    public void deletePiloto(@PathVariable Long id) {
        pilotoService.deletePiloto(id);
    }

    @Operation(summary = "Adicionar um avião a um piloto")
    @PostMapping("/{pilotoId}/avioes/{aviaoId}")
    public Piloto addAviaoToPiloto(@PathVariable Long pilotoId, @PathVariable Long aviaoId) {
        return pilotoService.addAviaoToPiloto(pilotoId, aviaoId);
    }
}