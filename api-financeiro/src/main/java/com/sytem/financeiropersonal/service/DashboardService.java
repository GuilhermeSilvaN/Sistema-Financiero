package com.sytem.financeiropersonal.service;

import com.sytem.financeiropersonal.dto.DashboardDTO;
import com.sytem.financeiropersonal.mapper.MapperDashboard;
import com.sytem.financeiropersonal.model.Dashboard;
import com.sytem.financeiropersonal.model.UserEntity;
import com.sytem.financeiropersonal.repository.DashboardRepository;
import com.sytem.financeiropersonal.repository.UserEntityRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DashboardService {
    private final DashboardRepository dashboardRepository;
    private final UserEntityRepository userEntityRepository;

    public DashboardService(
            DashboardRepository dashboardRepository,
            UserEntityRepository userEntityRepository
    ) {
        this.dashboardRepository = dashboardRepository;
        this.userEntityRepository = userEntityRepository;
    }

    //getAll;
    public List<DashboardDTO> findAllDashboard(String email ){
        UserEntity userEntity = userEntityRepository.findByEmailAndIsActiveTrue(email, true);

        List<Dashboard> dashboards = dashboardRepository.findByUserEntity(userEntity);

        return dashboards.stream().map(MapperDashboard::dashboardToDashboardDTO).toList();
    }
    //getById;
    public DashboardDTO findDashboardById(Long id, String email){
        UserEntity userEntity = userEntityRepository.findByEmailAndIsActiveTrue(email, true);
        Dashboard dashboard = dashboardRepository.findByIdAndUserEntity(id, userEntity);
        return MapperDashboard.dashboardToDashboardDTO(dashboard);
    }

    //create;
    public DashboardDTO createDashboard(String email){
        UserEntity userEntity = userEntityRepository.findByEmailAndIsActiveTrue(email, true);
        Dashboard dashboard = new Dashboard(userEntity);
        dashboardRepository.save(dashboard);

        return  MapperDashboard.dashboardToDashboardDTO(dashboard);
    }

    //delete;
    public void  deleteDashboardById(Long id){
        dashboardRepository.deleteById(id);
    }
}
