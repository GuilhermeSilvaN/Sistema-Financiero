package com.sytem.financeiropersonal.dto;

import com.sytem.financeiropersonal.model.Dashboard;
import com.sytem.financeiropersonal.model.Despesa;
import com.sytem.financeiropersonal.model.Entrada;
import com.sytem.financeiropersonal.model.UserEntity;

import java.util.List;

public record DashboardDTOCreate(
        UserEntity user,
        List<Despesa> despesas,
        List<Entrada> entradas
) {
    public DashboardDTOCreate(
            UserEntity user,
            List<Despesa> despesas,
            List<Entrada> entradas
    ){
        this.user = user;
        this.despesas = despesas;
        this.entradas = entradas;
    }

    public DashboardDTOCreate(
            Dashboard dashboard
    ){
        this(
                dashboard.getUser(),
                dashboard.getDespesas(),
                dashboard.getEntradas()
        );
    }
}