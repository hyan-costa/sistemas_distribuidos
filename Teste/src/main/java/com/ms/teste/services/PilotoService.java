package com.ms.teste.services;

import com.ms.teste.exceptions.ResourceNotFoundException;
import com.ms.teste.models.Aviao;
import com.ms.teste.models.Piloto;
import com.ms.teste.repositories.AviaoRepository;
import com.ms.teste.repositories.PilotoRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PilotoService {

    @Autowired
    private PilotoRepository pilotoRepository;
    @Autowired
    private AviaoRepository aviaoRepository;

    public List<Piloto> getAllPilotos() {
        return pilotoRepository.findAll();
    }

    public Piloto getPilotoById(Long id) {
        return pilotoRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("Piloto não encontrado"));
    }

    public Piloto savePiloto(Piloto piloto) {
        return pilotoRepository.save(piloto);
    }

    public void deletePiloto(Long id) {
        pilotoRepository.deleteById(id);
    }

    public Piloto addAviaoToPiloto(Long pilotoId, Long aviaoId) {
        Piloto piloto = pilotoRepository.findById(pilotoId)
                .orElseThrow(() -> new ResourceNotFoundException("Piloto não encontrado"));
        Aviao aviao = aviaoRepository.findById(aviaoId)
                .orElseThrow(() -> new ResourceNotFoundException("Avião não encontrado"));

        piloto.getAvioes().add(aviao);

        pilotoRepository.save(piloto);

        return piloto;
    }
}
