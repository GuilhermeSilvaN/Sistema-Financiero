package com.sytem.financeiropersonal.repository;

import com.sytem.financeiropersonal.model.Dashboard;
import com.sytem.financeiropersonal.model.MesDashboard;
import com.sytem.financeiropersonal.model.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface MesDashboardRepository extends JpaRepository<MesDashboard, Long> {
    List<MesDashboard> findByUserEntity(UserEntity userEntity);
    MesDashboard findByIdAndUserEntity(Long id, UserEntity userEntity);
}
