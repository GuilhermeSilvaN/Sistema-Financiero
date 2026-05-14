package com.sytem.financeiropersonal.dto;

import com.sytem.financeiropersonal.model.UserEntity;

public record UserEntityDTO(
        Long id,
        String username,
        String email,
        String password,
        Boolean isActive
) {
    public UserEntityDTO(
            Long id, String username, String email, String password, Boolean isActive
    ){
            this.id = id;
            this.username = username;
            this.email = email;
            this.password = password;
            this.isActive = isActive;
    }

    public UserEntityDTO(
            UserEntity userEntity
    ){
        this(
                userEntity.getId(),
                userEntity.getUsername(),
                userEntity.getEmail(),
                userEntity.getPassword(),
                userEntity.getIsActive()
        );
    }
}
