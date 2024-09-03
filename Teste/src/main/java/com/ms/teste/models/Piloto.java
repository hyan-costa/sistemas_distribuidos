package com.ms.teste.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.Data;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

@Entity
@Data
@Table(name = "piloto")
public class Piloto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;
    private int horasDeVoo;
    private String licenca;

    @JsonIgnoreProperties("pilotos")
    @ManyToMany
    @JoinTable(
            name = "piloto_aviao",
            joinColumns = @JoinColumn(name = "piloto_id"),
            inverseJoinColumns = @JoinColumn(name = "aviao_id")
    )
    private Set<Aviao> avioes = new HashSet<>();


    @Override
    public int hashCode() {
        return Objects.hash(id, nome); // Evite incluir coleções diretamente
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Piloto piloto = (Piloto) obj;
        return Objects.equals(id, piloto.id) &&
                Objects.equals(nome, piloto.nome);
    }
}
