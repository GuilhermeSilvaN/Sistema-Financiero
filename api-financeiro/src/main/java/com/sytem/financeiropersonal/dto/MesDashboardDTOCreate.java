package com.sytem.financeiropersonal.dto;

import com.sytem.financeiropersonal.model.Dashboard;
import com.sytem.financeiropersonal.model.UserEntity;

public record MesDashboardDTOCreate(
        Integer month,
        Integer year,
        UserEntity userEntity,
        Dashboard dashboard
) {
    public MesDashboardDTOCreate(Integer month, Integer year, UserEntity userEntity, Dashboard dashboard) {
        this.month = month;
        this.year = year;
        this.userEntity = userEntity;
        this.dashboard = dashboard;
    }
}
