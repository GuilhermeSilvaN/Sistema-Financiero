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

    @GetMapping("/{id_dashboard}")
    public ResponseEntity<List<EntradaDTO>> findAll(@PathVariable Long id_dashboard) {
        return ResponseEntity.ok().body(entradaService.findAllByDashboard(id_dashboard));
    }

    @GetMapping("/entr/{id_entrada}")
    public ResponseEntity<EntradaDTO> findByid(@PathVariable Long id_entrada) {
        return ResponseEntity.ok().body(entradaService.findById(id_entrada));
    }

    @PostMapping("/{id_mesdashboard}")
    public ResponseEntity<EntradaDTO> create(
            @PathVariable Long id_mesdashboard,
            @RequestBody EntradaDTOCreate entradaDTOCreate
    ) {
        EntradaDTO entrada = entradaService.createEntrada(id_mesdashboard, entradaDTOCreate);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(entrada.id()).toUri();

        return ResponseEntity.created(uri).body(entrada);
    }
    //update by id_dashboard and id_entrada;
    @PutMapping("/{id_dashboard}/{id_entrada}")
    public ResponseEntity<EntradaDTO> update(
            @PathVariable Long id_dashboard,
            @PathVariable Long id_entrada,
            @RequestBody EntradaDTOCreate entradaDTOCreate
    ){
        return ResponseEntity.ok().body(entradaService.updateEntrada(id_dashboard, id_entrada, entradaDTOCreate));
    }

    //delete
    @DeleteMapping("/{id_dashboard}/{id_entrada}")
    public ResponseEntity<Void> delete(
            @PathVariable Long id_dashboard,
            @PathVariable Long id_entrada
    ) {
        entradaService.deleteEntrada(id_entrada, id_dashboard);
        return ResponseEntity.noContent().build();
    }

}
