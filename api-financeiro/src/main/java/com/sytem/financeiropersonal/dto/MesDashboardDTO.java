package com.sytem.financeiropersonal.dto;

import com.sytem.financeiropersonal.model.Dashboard;
import com.sytem.financeiropersonal.model.UserEntity;

public record MesDashboardDTO(
        Long mes_id,
        Integer month,
        Integer year,
        Dashboard dashboard
) {
    public MesDashboardDTO(Long mes_id, Integer month, Integer year, Dashboard dashboard) {
        this.mes_id = mes_id;
        this.month = month;
        this.year = year;
        this.dashboard = dashboard;
    }
}