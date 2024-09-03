package com.ms.teste.services;

import com.ms.teste.models.Aviao;
import com.ms.teste.repositories.AviaoRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AviaoService {

    @Autowired
    private AviaoRepository aviaoRepository;

    public List<Aviao> getAllAvioes() {
        return aviaoRepository.findAll();
    }

    public Aviao getAviaoById(Long id) {
        return aviaoRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("Avião não encontrado"));
    }

    public Aviao saveAviao(Aviao aviao) {
        return aviaoRepository.save(aviao);
    }

    public void deleteAviao(Long id) {
        aviaoRepository.deleteById(id);
    }
}