package com.ms.teste.models;


import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.Data;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

@Entity
@Data
@Table(name = "aviao")
public class Aviao {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String modelo;
    private String fabricante;
    private int capacidade;
    private int anoDeFabricacao;

//    @JsonIgnore
    @JsonIgnoreProperties("avioes")
    @ManyToMany(mappedBy = "avioes")
    private Set<Piloto> pilotos = new HashSet<>();


    @Override
    public int hashCode() {
        return Objects.hash(id, modelo); // Evite incluir coleções diretamente
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Aviao aviao = (Aviao) obj;
        return Objects.equals(id, aviao.id) &&
                Objects.equals(modelo, aviao.modelo);
    }
}
