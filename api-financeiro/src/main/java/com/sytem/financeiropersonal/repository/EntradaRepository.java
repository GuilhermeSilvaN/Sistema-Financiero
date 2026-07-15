package com.sytem.financeiropersonal.repository;

import com.sytem.financeiropersonal.model.Entrada;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface EntradaRepository extends JpaRepository<Entrada, Long> {
    List<Entrada> findByDashboardId(Long dashboardId);
    Optional<Entrada> findByIdAndDashboardId(Long id, Long dashboardId);
}
