package com.sytem.financeiropersonal.dto;

import com.sytem.financeiropersonal.model.Dashboard;
import com.sytem.financeiropersonal.model.Despesa;
import com.sytem.financeiropersonal.model.Entrada;
import com.sytem.financeiropersonal.model.MesDashboard;

import java.util.List;

public record DashboardDTO(
        Long id,
        Long id_mesDashboard,
        List<Despesa> despesas,
        List<Entrada> entradas,
        Double totalDespesas,
        Double totalEntradas,
        Double totalSaldo
) {
    public DashboardDTO(
            Long id,
            Long id_mesDashboard,
            List<Despesa> despesas,
            List<Entrada> entradas,
            Double totalDespesas,
            Double totalEntradas,
            Double totalSaldo
    ){
        this.id = id;
        this.id_mesDashboard = id_mesDashboard;
        this.despesas = despesas;
        this.entradas = entradas;
        this.totalDespesas = totalDespesas;
        this.totalEntradas = totalEntradas;
        this.totalSaldo = totalSaldo;
    }

    public DashboardDTO(
            Dashboard dashboard
    ){
        this(
                dashboard.getId(),
                dashboard.getMes().getId(),
                dashboard.getDespesas(),
                dashboard.getEntradas(),
                dashboard.getTotalDespesas(),
                dashboard.getTotalEntradas(),
                dashboard.getTotalSaldo()
        );
    }
}
