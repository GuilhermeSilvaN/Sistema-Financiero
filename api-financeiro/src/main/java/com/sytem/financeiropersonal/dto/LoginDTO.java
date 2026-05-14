package com.sytem.financeiropersonal.dto;

import com.sytem.financeiropersonal.model.UserEntity;

public record LoginDTO(
        String email,
        String password
) {
    public LoginDTO(UserEntity userEntity){
        this(
                userEntity.getEmail(),
                userEntity.getPassword()
        );
    }
}
