package com.sytem.financeiropersonal.repository;

import com.sytem.financeiropersonal.model.Despesa;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DespesaRepository extends JpaRepository<Despesa, Long> {
    List<Despesa> findByIdDashboard(Long idDashboard);
}
