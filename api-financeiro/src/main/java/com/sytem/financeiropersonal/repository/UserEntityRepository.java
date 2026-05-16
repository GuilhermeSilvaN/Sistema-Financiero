package com.sytem.financeiropersonal.repository;

import com.sytem.financeiropersonal.model.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserEntityRepository extends JpaRepository<UserEntity,Long> {
    Optional<UserEntity> findByEmailAndIsActiveTrue(String email, Boolean isActive);
    Optional<UserEntity> findByUsernameAndIsActive(String username,  Boolean isActive);
}
