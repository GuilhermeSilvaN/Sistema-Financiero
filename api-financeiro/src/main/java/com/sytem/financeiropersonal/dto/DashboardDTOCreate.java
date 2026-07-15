package com.sytem.financeiropersonal.dto;

import com.sytem.financeiropersonal.model.*;

import java.util.List;

public record DashboardDTOCreate(
        MesDashboard mesDashboard,
        List<Despesa> despesas,
        List<Entrada> entradas
) {
    public DashboardDTOCreate(
            MesDashboard mesDashboard,
            List<Despesa> despesas,
            List<Entrada> entradas
    ){
        this.mesDashboard = mesDashboard;
        this.despesas = despesas;
        this.entradas = entradas;
    }

    public DashboardDTOCreate(
            Dashboard dashboard
    ){
        this(
                dashboard.getMes(),
                dashboard.getDespesas(),
                dashboard.getEntradas()
        );
    }
}