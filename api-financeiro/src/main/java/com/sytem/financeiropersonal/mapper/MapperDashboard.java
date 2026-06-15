package com.sytem.financeiropersonal.mapper;

import com.sytem.financeiropersonal.dto.DashboardDTO;
import com.sytem.financeiropersonal.dto.DashboardDTOCreate;
import com.sytem.financeiropersonal.model.Dashboard;

public class MapperDashboard {
    public static Dashboard dashboardDTOCreateToDashboard(DashboardDTOCreate dashboardDTOCreate) {
        Dashboard dashboard = new Dashboard(
                dashboardDTOCreate.userEntity()
        );
        dashboard.getEntradas().addAll(dashboardDTOCreate.entradas());
        dashboard.getDespesas().addAll(dashboardDTOCreate.despesas());

        return dashboard;
    }

    public static DashboardDTO dashboardToDashboardDTO(Dashboard dashboard) {
        return new DashboardDTO(
                dashboard.getId(),
                dashboard.getDespesas(),
                dashboard.getEntradas()
        );
    }

    public static DashboardDTOCreate dashboardToDashboardDTOCreate(Dashboard dashboard) {
        return new DashboardDTOCreate(
                dashboard.getUserEntity(),
                dashboard.getDespesas(),
                dashboard.getEntradas()
        );
    }

    public static void updateDashboard(Dashboard dashboard, DashboardDTOCreate dashboardDTOCreate) {
        dashboard.setDespesas(dashboardDTOCreate.despesas());
        dashboard.setEntradas(dashboardDTOCreate.entradas());
    }
}

