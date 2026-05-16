package com.sytem.financeiropersonal.repository;

import com.sytem.financeiropersonal.model.Entrada;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EntradaRepository extends JpaRepository<Entrada, Long> {
}
