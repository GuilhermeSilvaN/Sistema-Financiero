package com.sytem.financeiropersonal.service;

import com.sytem.financeiropersonal.dto.MesDashboardDTO;
import com.sytem.financeiropersonal.dto.RequestDate;
import com.sytem.financeiropersonal.mapper.MapperMesDashboard;
import com.sytem.financeiropersonal.model.Dashboard;
import com.sytem.financeiropersonal.model.MesDashboard;
import com.sytem.financeiropersonal.model.UserEntity;
import com.sytem.financeiropersonal.repository.MesDashboardRepository;
import com.sytem.financeiropersonal.repository.UserEntityRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MesDashboardService {

    private final MesDashboardRepository mesDashboardRepository;
    private final UserEntityRepository userEntityRepository;

    public MesDashboardService(
            MesDashboardRepository mesDashboardRepository,
            UserEntityRepository userEntityRepository
    ){
        this.mesDashboardRepository = mesDashboardRepository;
        this.userEntityRepository = userEntityRepository;
    }

    //getAll;
    public List<MesDashboardDTO>  findAllMesDashboard(String email){
        UserEntity userEntity = userEntityRepository.findByEmailAndIsActiveTrue(email, true);

        List<MesDashboard> mesDashboards = mesDashboardRepository.findByUserEntity(userEntity);

        return mesDashboards.stream().map(MapperMesDashboard::mesDashboardToMesDashboardDTO).toList();
    }

    //getById;
    public MesDashboardDTO findMesDashboardById(Long id_MesDashboard, String email){
        UserEntity userEntity = userEntityRepository.findByEmailAndIsActiveTrue(email, true);
        MesDashboard mesDashboard = mesDashboardRepository.findByIdAndUserEntity(id_MesDashboard, userEntity);
        return MapperMesDashboard.mesDashboardToMesDashboardDTO(mesDashboard);
    }

    public MesDashboardDTO createMesDashboard(String email, RequestDate requestDate){

        UserEntity userEntity = userEntityRepository.findByEmailAndIsActiveTrue(email, true);
        MesDashboard mesDashboard = new MesDashboard();
        mesDashboard.setUserEntity(userEntity);

        Dashboard dashboard = new Dashboard();
        mesDashboard.setDashboard(dashboard);
        mesDashboard.setMonth(requestDate.month());
        mesDashboard.setYear(requestDate.year());

        mesDashboardRepository.save(mesDashboard);

        return  MapperMesDashboard.mesDashboardToMesDashboardDTO(mesDashboard);
    }

}
