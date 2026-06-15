package com.sytem.financeiropersonal.service;

import com.sytem.financeiropersonal.dto.DashboardDTO;
import com.sytem.financeiropersonal.dto.EntradaDTO;
import com.sytem.financeiropersonal.dto.EntradaDTOCreate;
import com.sytem.financeiropersonal.mapper.MapperEntrada;
import com.sytem.financeiropersonal.model.Dashboard;
import com.sytem.financeiropersonal.model.Entrada;
import com.sytem.financeiropersonal.repository.DashboardRepository;
import com.sytem.financeiropersonal.repository.EntradaRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EntradaService {
    private final EntradaRepository entradaRepository;
    private final DashboardRepository dashboardRepository;

    public EntradaService(
            EntradaRepository entradaRepository,
            DashboardRepository dashboardRepository
            ) {
        this.entradaRepository = entradaRepository;
        this.dashboardRepository = dashboardRepository;
    }

    //getAll
    public List<EntradaDTO> findAllByDashboard(Long id_dashboard){
        Dashboard dashboard = dashboardRepository.findById(id_dashboard)
                .orElseThrow(() -> new RuntimeException("dashboard nao encontrado"));
        List<Entrada> entradas = dashboard.getEntradas();
        return entradas.stream().map(MapperEntrada::entradaToEntradaDTO).toList();
    }

    //getById
    public EntradaDTO findById(Long id_entrada){
        Entrada entrada = entradaRepository.findById(id_entrada)
                .orElseThrow(() -> new RuntimeException("Entrada inexistente"));
        return MapperEntrada.entradaToEntradaDTO(entrada);
    }

    //create (dashboard id : Long; EntradaDTOCreate)
    public EntradaDTO createEntrada(Long id_dashboard, EntradaDTOCreate  entradaDTOCreate){
        Entrada entrada = MapperEntrada.entradaDTOCreateToEntrada(entradaDTOCreate);
        Dashboard dashboard = dashboardRepository.findById(id_dashboard)
                .orElseThrow(() -> new RuntimeException("dashboard nao encontrado"));
        entrada.setDashboard(dashboard);

        entradaRepository.save(entrada);

        return MapperEntrada.entradaToEntradaDTO(entrada);
    }

    //updateById (Long Entrada_id, EntradaDTOCreate entradaDTOCreate, Long idDashboard)
    public EntradaDTO updateEntrada(Long id_entrada, Long id_dashboard, EntradaDTOCreate entradaDTOCreate){

        Entrada entrada = entradaRepository.findById(id_entrada)
                .orElseThrow(() -> new RuntimeException("Entrada inexistente"));

        Dashboard dashboard = dashboardRepository.findById(id_dashboard)
                .orElseThrow(() -> new RuntimeException("dashboard nao encontrado"));//procura pelo dashboard passado por id;
        entrada.setDashboard(dashboard); //setta o dashboard;

        MapperEntrada.updateEntrada(entrada, entradaDTOCreate); //faz o update;
        entradaRepository.save(entrada); //salva a entrada;

        return MapperEntrada.entradaToEntradaDTO(entrada); //retorna no formato DTO;
    }

    //deleteById
    public void deleteEntrada(Long id){
        entradaRepository.deleteById(id);
    }
}
