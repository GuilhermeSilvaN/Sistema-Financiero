package com.sytem.financeiropersonal.service;

import com.sytem.financeiropersonal.dto.EntradaDTO;
import com.sytem.financeiropersonal.dto.EntradaDTOCreate;
import com.sytem.financeiropersonal.mapper.MapperEntrada;
import com.sytem.financeiropersonal.model.Entrada;
import com.sytem.financeiropersonal.repository.EntradaRepository;

import java.util.List;

public class EntradaService {
    private final EntradaRepository entradaRepository;

    public EntradaService(EntradaRepository entradaRepository) {
        this.entradaRepository = entradaRepository;
    }

    //getAll
    public List<EntradaDTO> findAll(Long idDashboard){
        List<Entrada> entradas = entradaRepository.findByIdDashboard(idDashboard);
        return entradas.stream().map(MapperEntrada::entradaToEntradaDTO).toList();
    }

    //getById
    public EntradaDTO findById(Long id){
        Entrada entrada = entradaRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Entrada inexistente"));
        return MapperEntrada.entradaToEntradaDTO(entrada);
    }

    //create
    public EntradaDTO createEntrada(EntradaDTOCreate  entradaDTOCreate){
        Entrada entrada = MapperEntrada.entradaDTOCreateToEntrada(entradaDTOCreate);
        entradaRepository.save(entrada);

        return MapperEntrada.entradaToEntradaDTO(entrada);
    }

    //updateById
    public EntradaDTO updateEntrada(Long id, EntradaDTOCreate entradaDTOCreate){
        Entrada entrada = new Entrada();
        MapperEntrada.updateEntrada(entrada, entradaDTOCreate);
        entradaRepository.save(entrada);

        return MapperEntrada.entradaToEntradaDTO(entrada);
    }

    //deleteById
    public void deleteEntrada(Long id){
        entradaRepository.deleteById(id);
    }
}
