package com.sytem.financeiropersonal.dto;

import com.sytem.financeiropersonal.model.Dashboard;
import com.sytem.financeiropersonal.model.Despesa;
import com.sytem.financeiropersonal.model.Entrada;
import com.sytem.financeiropersonal.model.UserEntity;

import java.util.List;

public record DashboardDTOCreate(
        UserEntity userEntity,
        List<Despesa> despesas,
        List<Entrada> entradas
) {
    public DashboardDTOCreate(
            UserEntity userEntity,
            List<Despesa> despesas,
            List<Entrada> entradas
    ){
        this.userEntity = userEntity;
        this.despesas = despesas;
        this.entradas = entradas;
    }

    public DashboardDTOCreate(
            Dashboard dashboard
    ){
        this(
                dashboard.getUserEntity(),
                dashboard.getDespesas(),
                dashboard.getEntradas()
        );
    }
}