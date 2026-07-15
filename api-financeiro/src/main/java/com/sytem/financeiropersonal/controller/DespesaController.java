package com.sytem.financeiropersonal.controller;

import com.sytem.financeiropersonal.dto.DespesaDTO;
import com.sytem.financeiropersonal.dto.DespesaDTOCreate;
import com.sytem.financeiropersonal.dto.RequestDash;
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
    @GetMapping("/{id}")
    public ResponseEntity<List<DespesaDTO>> findAll(@PathVariable Long id) {
        return ResponseEntity.ok().body(despesaService.findAllByDashboard(id));
    }

    //GET BY ID_DESPESA
    @GetMapping("/desp/{id_despesa}")
    public ResponseEntity<DespesaDTO> findById(@PathVariable Long id_despesa) {
        return ResponseEntity.ok().body(despesaService.findById(id_despesa));
    }

    @PostMapping("/{id_mesdashboard}")
    public ResponseEntity<DespesaDTO> create(
            @PathVariable Long id_mesdashboard,
            @RequestBody DespesaDTOCreate despesaDTOCreate
    ) {
        DespesaDTO despesa = despesaService.createDespesa(id_mesdashboard, despesaDTOCreate);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(despesa.id()).toUri();

        return ResponseEntity.created(uri).body(despesa);
    }

    //update by id;
    @PutMapping("/{id_dashboard}/{id_despesa}")
    public ResponseEntity<DespesaDTO> update (
            @PathVariable Long id_dashboard,
            @PathVariable Long id_despesa,
            @RequestBody DespesaDTOCreate despesaDTOCreate
    ) {
        return ResponseEntity.ok().body(despesaService.updateDespesa(id_dashboard, id_despesa, despesaDTOCreate));
    }

    //delete by id;
    @DeleteMapping("/{id_dashboard}/{id_despesa}")
    public ResponseEntity<Void> delete (
            @PathVariable Long id_dashboard,
            @PathVariable Long id_despesa
    ) {
        despesaService.deleteDespesa(id_despesa, id_dashboard);
        return ResponseEntity.noContent().build();
    }

}
