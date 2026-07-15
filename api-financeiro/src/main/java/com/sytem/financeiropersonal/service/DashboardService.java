package com.sytem.financeiropersonal.service;

import com.sytem.financeiropersonal.dto.DashboardDTO;
import com.sytem.financeiropersonal.dto.RequestDash;
import com.sytem.financeiropersonal.mapper.MapperDashboard;
import com.sytem.financeiropersonal.model.Dashboard;
import com.sytem.financeiropersonal.model.MesDashboard;
import com.sytem.financeiropersonal.model.UserEntity;
import com.sytem.financeiropersonal.repository.DashboardRepository;
import com.sytem.financeiropersonal.repository.MesDashboardRepository;
import com.sytem.financeiropersonal.repository.UserEntityRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DashboardService {
    private final DashboardRepository dashboardRepository;
    private final MesDashboardRepository mesDashboardRepository;

    public DashboardService(
            DashboardRepository dashboardRepository,
            MesDashboardRepository mesDashboardRepository
    ) {
        this.dashboardRepository = dashboardRepository;
        this.mesDashboardRepository = mesDashboardRepository;
    }
    
    //getById;
    public DashboardDTO findDashboardById(Long id, RequestDash mes_dash) {
        MesDashboard mesId = mesDashboardRepository.findById(mes_dash.id_mes()).get();
        Dashboard dashboard = dashboardRepository.findByIdAndMesDashboard(id, mesId);
        return MapperDashboard.dashboardToDashboardDTO(dashboard);
    }

    //create;
    public DashboardDTO createDashboard(RequestDash mes_dash) {
        MesDashboard mesId = mesDashboardRepository.findById(mes_dash.id_mes()).get();

        Dashboard dashboard = new Dashboard();
        dashboard.setMes(mesId);
        dashboardRepository.save(dashboard);

        return  MapperDashboard.dashboardToDashboardDTO(dashboard);
    }

    //delete;
    public void  deleteDashboardById(Long id){
        dashboardRepository.deleteById(id);
    }
}
