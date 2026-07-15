package com.sytem.financeiropersonal.mapper;

import com.sytem.financeiropersonal.dto.MesDashboardDTO;
import com.sytem.financeiropersonal.dto.MesDashboardDTOCreate;
import com.sytem.financeiropersonal.model.MesDashboard;

public class MapperMesDashboard {

    //MesDashboardDTOCreate (dto) -> MesDashboard (entity)
    public static MesDashboard mesDashboardDTOCreateToMesDashboard(MesDashboardDTOCreate mesDashboardDTOCreate) {
        return new MesDashboard(
                mesDashboardDTOCreate.month(),
                mesDashboardDTOCreate.year(),
                mesDashboardDTOCreate.userEntity(),
                mesDashboardDTOCreate.dashboard()
        );
    }

    //MesDashboard (entity) -> MesDashboardDTO (dto)
    public static MesDashboardDTO mesDashboardToMesDashboardDTO(MesDashboard mesDashboard) {
        return new MesDashboardDTO(
                mesDashboard.getId(),
                mesDashboard.getMonth(),
                mesDashboard.getYear(),
                mesDashboard.getDashboard()
        );
    }
}
