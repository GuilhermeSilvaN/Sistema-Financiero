package com.sytem.financeiropersonal.controller;

import com.sytem.financeiropersonal.dto.DashboardDTO;
import com.sytem.financeiropersonal.service.DashboardService;
import com.sytem.financeiropersonal.service.UserEntityService;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("dashboard")
public class DashboardController {
    private final DashboardService dashboardService;

    public DashboardController(DashboardService dashboardService) {
        this.dashboardService = dashboardService;
    }

    //getAll by user;
    @GetMapping("/list")
    public ResponseEntity<List<DashboardDTO>> findAllByUser(
            Authentication authentication
    ){
        String email =  authentication.getName();
        return ResponseEntity.ok().body(dashboardService.findAllDashboard(email));
    }

    //getById by user;
    @GetMapping("/{id}")
    public ResponseEntity<DashboardDTO> findDashboardById(@PathVariable Long id,  Authentication authentication){
        String email =  authentication.getName();
        return ResponseEntity.ok().body(dashboardService.findDashboardById(id, email));
    }

    //create a new dashboard;
    @PostMapping
    public ResponseEntity<DashboardDTO> createDashboard(Authentication authentication){
        String email =  authentication.getName();
        DashboardDTO dashboard = dashboardService.createDashboard(authentication.getName());
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(dashboard.id()).toUri();

        return ResponseEntity.created(uri).body(dashboard);
    }

    //delete dashboard;
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteDashboard(@PathVariable Long id,  Authentication authentication){
        String email =  authentication.getName();
        dashboardService.deleteDashboardById(id);

        return ResponseEntity.noContent().build();
    }

}
