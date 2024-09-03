package com.ms.teste.repositories;


import com.ms.teste.models.Aviao;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AviaoRepository extends JpaRepository<Aviao, Long> {
}
