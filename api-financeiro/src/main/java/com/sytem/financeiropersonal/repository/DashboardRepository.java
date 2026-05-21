package com.sytem.financeiropersonal.repository;

import com.sytem.financeiropersonal.model.Dashboard;
import com.sytem.financeiropersonal.model.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DashboardRepository extends JpaRepository<Dashboard, Long> {
    Dashboard findByIdDashboard(Long id);
    Dashboard findByIdDashboardAndUserEntity(long id_dashboard, UserEntity userEntity);
    List<Dashboard> findAllDashboardByUserEntity(UserEntity userEntity);
}
