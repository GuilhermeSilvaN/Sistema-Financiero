package com.sytem.financeiropersonal.controller;

import com.sytem.financeiropersonal.dto.MesDashboardDTO;
import com.sytem.financeiropersonal.dto.RequestDate;
import com.sytem.financeiropersonal.service.MesDashboardService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("mesdashboard")
public class MesDashboardController {
    private final MesDashboardService mesDashboardService;

    public MesDashboardController(MesDashboardService mesDashboardService){
        this.mesDashboardService = mesDashboardService;
    }

    //getAll;
    @GetMapping
    public ResponseEntity<List<MesDashboardDTO>> findAllMesDashboard(
            Authentication auth
    ){
        String email = auth.getName();
        return ResponseEntity.ok().body(mesDashboardService.findAllMesDashboard(email));
    }

    //getById
    @GetMapping("/{id}")
    public ResponseEntity<MesDashboardDTO> findMesDashboardById(@PathVariable Long id, Authentication auth){
        String email = auth.getName();
        return ResponseEntity.ok().body(mesDashboardService.findMesDashboardById(id, email));
    }

    @PostMapping
    public ResponseEntity<MesDashboardDTO> createMesDashboard(@RequestBody RequestDate request, Authentication auth){
        String email = auth.getName();
        MesDashboardDTO mesDTO = mesDashboardService.createMesDashboard(email, request);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(mesDTO.mes_id()).toUri();

        return ResponseEntity.status(HttpStatus.CREATED).body(mesDTO);
    }
}
