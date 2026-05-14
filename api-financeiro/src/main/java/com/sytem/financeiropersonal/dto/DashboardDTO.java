package com.sytem.financeiropersonal.dto;

import com.sytem.financeiropersonal.model.Dashboard;
import com.sytem.financeiropersonal.model.Despesa;
import com.sytem.financeiropersonal.model.Entrada;

import java.util.List;

public record DashboardDTO(
        Long id,
        List<Despesa> despesas,
        List<Entrada> entradas
) {
    public DashboardDTO(
            Long id,
            List<Despesa> despesas,
            List<Entrada> entradas
    ){
        this.id = id;
        this.despesas = despesas;
        this.entradas = entradas;
    }

    public DashboardDTO(
            Dashboard dashboard
    ){
        this(
                dashboard.getId(),
                dashboard.getDespesas(),
                dashboard.getEntradas()
        );
    }
}
