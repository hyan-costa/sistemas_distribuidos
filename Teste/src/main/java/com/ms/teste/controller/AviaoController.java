package com.ms.teste.controller;


import com.ms.teste.models.Aviao;
import com.ms.teste.services.AviaoService;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/avioes")
public class AviaoController {

    @Autowired
    private AviaoService aviaoService;

    @Operation(summary = "Obter todos os aviões")
    @GetMapping
    public List<Aviao> getAllAvioes() {
        return aviaoService.getAllAvioes();
    }

    @Operation(summary = "Obter um avião pelo ID")
    @GetMapping("/{id}")
    public Aviao getAviaoById(@PathVariable Long id) {
        return aviaoService.getAviaoById(id);
    }

    @Operation(summary = "Criar um novo avião")
    @PostMapping
    public Aviao createAviao(@RequestBody Aviao aviao) {
        return aviaoService.saveAviao(aviao);
    }

    @Operation(summary = "Deletar um avião pelo ID")
    @DeleteMapping("/{id}")
    public void deleteAviao(@PathVariable Long id) {
        aviaoService.deleteAviao(id);
    }
}
