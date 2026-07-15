package com.sytem.financeiropersonal.service;

import com.sytem.financeiropersonal.dto.DespesaDTO;
import com.sytem.financeiropersonal.dto.DespesaDTOCreate;
import com.sytem.financeiropersonal.mapper.MapperDespesa;
import com.sytem.financeiropersonal.model.Dashboard;
import com.sytem.financeiropersonal.model.Despesa;
import com.sytem.financeiropersonal.repository.DashboardRepository;
import com.sytem.financeiropersonal.repository.DespesaRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

@Service
public class DespesaService {
    private final DespesaRepository despesaRepository;
    private final DashboardRepository dashboardRepository;

    public DespesaService(
            DespesaRepository despesaRepository,
            DashboardRepository dashboardRepository
    ) {
        this.despesaRepository = despesaRepository;
        this.dashboardRepository = dashboardRepository;
    }

    //getAll
    public List<DespesaDTO> findAllByDashboard(Long id_dashboard) {
        List<Despesa> despesas = despesaRepository.findByDashboardId(id_dashboard);
        return despesas.stream().map(MapperDespesa::despesaToDespesaDTO).toList();
    }

    //getById
    public DespesaDTO findById(Long id_despesa) {
        Despesa despesa = despesaRepository.findById(id_despesa)
                .orElseThrow(() -> new RuntimeException("Despesa inexistente"));
        return MapperDespesa.despesaToDespesaDTO(despesa);
    }

    //create a new despesa (dashboard id : Long; DespesaDTOCreate : record)
    public DespesaDTO createDespesa(Long id_dashboard, DespesaDTOCreate despesaDTOCreate) {
        Dashboard dashboard = dashboardRepository.findById(id_dashboard)
                .orElseThrow(() -> new RuntimeException("dashboard nao encontrado"));

        Despesa despesa = MapperDespesa.despesaDTOCreateToDespesa(despesaDTOCreate);
        despesa.setDashboard(dashboard);
        despesa = despesaRepository.save(despesa);

        return MapperDespesa.despesaToDespesaDTO(despesa);
    }

    //updateById (Long id_despesa, Long id_dashboard, DespesaDTOCreate despesaDTOCreate);
    public DespesaDTO updateDespesa(
            Long id_dashboard,
            Long id_despesa,
            DespesaDTOCreate despesaDTOCreate
    ) {

        Dashboard dashboard = dashboardRepository.findById(id_dashboard)
                .orElseThrow(() -> new RuntimeException("dashboard nao encontrado"));

        Despesa despesa = despesaRepository.findById(id_despesa)
                .orElseThrow(() -> new RuntimeException("despesa nao encontrada"));

        if (!despesa.getDashboard().getId().equals(id_dashboard)) {
            throw new RuntimeException("Esta despesa não pertence a este dashboard");
        }

        MapperDespesa.updateDespesa(despesa, despesaDTOCreate);
        despesaRepository.save(despesa);

        return MapperDespesa.despesaToDespesaDTO(despesa);
    }

    //deleteById (Long id_despesa);
    public void deleteDespesa(Long id_despesa, Long id_dashboard) {
        Despesa despesa = despesaRepository
                .findByIdAndDashboardId(id_despesa, id_dashboard)
                .orElseThrow(() -> new RuntimeException("despesa nao encontrada"));
        despesaRepository.delete(despesa);
    }
}
