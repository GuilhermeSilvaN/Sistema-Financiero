package com.sytem.financeiropersonal.mapper;

import com.sytem.financeiropersonal.dto.DashboardDTO;
import com.sytem.financeiropersonal.dto.DashboardDTOCreate;
import com.sytem.financeiropersonal.model.Dashboard;

public class MapperDashboard {
    public static Dashboard dashboardDTOCreateToDashboard(DashboardDTOCreate dashboardDTOCreate) {
        Dashboard dashboard = new Dashboard();
        dashboard.setMes(dashboardDTOCreate.mesDashboard());
        dashboard.getEntradas().addAll(dashboardDTOCreate.entradas());
        dashboard.getDespesas().addAll(dashboardDTOCreate.despesas());

        return dashboard;
    }

    public static DashboardDTO dashboardToDashboardDTO(Dashboard dashboard) {
        return new DashboardDTO(
                dashboard.getId(),
                dashboard.getMes().getId(),
                dashboard.getDespesas(),
                dashboard.getEntradas(),
                dashboard.getTotalDespesas(),
                dashboard.getTotalEntradas(),
                dashboard.getTotalSaldo()
        );
    }

    public static DashboardDTOCreate dashboardToDashboardDTOCreate(Dashboard dashboard) {
        return new DashboardDTOCreate(
                dashboard.getMes(),
                dashboard.getDespesas(),
                dashboard.getEntradas()
        );
    }

    public static void updateDashboard(Dashboard dashboard, DashboardDTOCreate dashboardDTOCreate) {
        dashboard.setMes(dashboardDTOCreate.mesDashboard());
        dashboard.setDespesas(dashboardDTOCreate.despesas());
        dashboard.setEntradas(dashboardDTOCreate.entradas());
    }
}

