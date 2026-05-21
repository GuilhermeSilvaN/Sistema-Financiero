package com.sytem.financeiropersonal.controller;

import com.sytem.financeiropersonal.dto.EntradaDTO;
import com.sytem.financeiropersonal.dto.EntradaDTOCreate;
import com.sytem.financeiropersonal.service.EntradaService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("entrada")
public class EntradaController {

    private final EntradaService entradaService;

    public EntradaController(EntradaService entradaService) {
        this.entradaService = entradaService;
    }

    @GetMapping("list/{id}")
    public ResponseEntity<List<EntradaDTO>> findAll(@PathVariable Long id_dashboard) {
        return ResponseEntity.ok().body(entradaService.findAllByDashboard(id_dashboard));
    }

    @GetMapping("/{id_entrada}")
    public ResponseEntity<EntradaDTO> findByid(@PathVariable Long id_entrada) {
        return ResponseEntity.ok().body(entradaService.findById(id_entrada));
    }

    @PostMapping
    public ResponseEntity<EntradaDTO> create(
            @RequestBody Long id_dashboard,
            @RequestBody EntradaDTOCreate entradaDTOCreate
    ) {
        EntradaDTO entrada = entradaService.createEntrada(id_dashboard, entradaDTOCreate);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id_entrada}").buildAndExpand(entrada.id()).toUri();
        return ResponseEntity.created(uri).body(entrada);
    }

    @PutMapping("/{id}")
    public ResponseEntity<EntradaDTO> update(
            @PathVariable Long id_entrada,
            @RequestBody Long id_dashboard,
            @RequestBody EntradaDTOCreate entradaDTOCreate
    ){
        return ResponseEntity.ok().body(entradaService.updateEntrada(id_entrada, id_dashboard, entradaDTOCreate));
    }

    //delete
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id_entrada) {
        entradaService.deleteEntrada(id_entrada);
        return ResponseEntity.noContent().build();
    }

}
