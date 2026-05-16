package com.sytem.financeiropersonal.mapper;

import com.sytem.financeiropersonal.dto.UserEntityDTO;
import com.sytem.financeiropersonal.dto.UserEntityDTOCreate;
import com.sytem.financeiropersonal.model.UserEntity;

public class MapperUserEntity {
    //usado para salvar e atualizar quando precisar de uma instancia de userEntity;
    public static UserEntity UserEntityDTOCreateToUserEntity(UserEntityDTOCreate userEntityDTOCreate){
        return new UserEntity(
                userEntityDTOCreate.username(),
                userEntityDTOCreate.email(),
                userEntityDTOCreate.password(),
                userEntityDTOCreate.isActive()
        );
    }

    //usado para retornar mostrando o id;
    public static UserEntityDTO UserEntityToUserEntityDTO(UserEntity userEntity){
        return new UserEntityDTO(
                userEntity.getId(),
                userEntity.getUsername(),
                userEntity.getEmail(),
                userEntity.getPassword(),
                userEntity.getIsActive()
        );
    }

    //usado para update de user;
    public static void userEntityUpdate(UserEntity userEntity, UserEntityDTOCreate userEntityDTOCreate){
        userEntity.setUsername(userEntityDTOCreate.username());
        userEntity.setEmail(userEntityDTOCreate.email());
        userEntity.setPassword(userEntityDTOCreate.password());
        userEntity.setIsActive(userEntityDTOCreate.isActive());
    }
}
