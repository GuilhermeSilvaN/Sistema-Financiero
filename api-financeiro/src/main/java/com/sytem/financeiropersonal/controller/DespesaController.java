package com.sytem.financeiropersonal.controller;

import com.sytem.financeiropersonal.dto.DespesaDTO;
import com.sytem.financeiropersonal.dto.DespesaDTOCreate;
import com.sytem.financeiropersonal.service.DespesaService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("despesa")
public class DespesaController {
    private final DespesaService despesaService;

    public DespesaController(DespesaService despesaService) {
        this.despesaService = despesaService;
    }

    //GET ALL DESPESA BY ID_DASHBOARD;
    @GetMapping("/list/{id}")
    public ResponseEntity<List<DespesaDTO>> findAll(@PathVariable Long id_dashboard) {
        return ResponseEntity.ok().body(despesaService.findAllByDashboard(id_dashboard));
    }

    //GET BY ID_DESPESA
    @GetMapping("/{id_despesa}")
    public ResponseEntity<DespesaDTO> findById(@PathVariable Long id_despesa) {
        return ResponseEntity.ok().body(despesaService.findById(id_despesa));
    }

    @PostMapping
    public ResponseEntity<DespesaDTO> create(
            @RequestBody Long id_dashboard,
            @RequestBody DespesaDTOCreate despesaDTOCreate
    ) {
        DespesaDTO despesa = despesaService.createDespesa(id_dashboard, despesaDTOCreate);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(despesa.id()).toUri();

        return ResponseEntity.created(uri).body(despesa);
    }

    //update by id;
    @PutMapping("/{id}")
    public ResponseEntity<DespesaDTO> update (
            @PathVariable Long id_despesa,
            @RequestBody Long id_dashboard,
            @RequestBody DespesaDTOCreate despesaDTOCreate
    ) {
        return ResponseEntity.ok().body(despesaService.updateDespesa(id_despesa, id_dashboard, despesaDTOCreate));
    }

    //delete by id;
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete (@PathVariable Long id_despesa) {
        despesaService.deleteDespesa(id_despesa);
        return ResponseEntity.noContent().build();
    }

}
