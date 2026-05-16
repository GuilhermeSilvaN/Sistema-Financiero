package com.sytem.financeiropersonal.service;

import com.sytem.financeiropersonal.dto.UserEntityDTO;
import com.sytem.financeiropersonal.mapper.MapperUserEntity;
import com.sytem.financeiropersonal.model.UserEntity;
import com.sytem.financeiropersonal.repository.UserEntityRepository;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserEntityService  implements UserDetailsService {

    private UserEntityRepository userEntityRepository;

    public UserEntityService(UserEntityRepository userEntityRepository) {
        this.userEntityRepository = userEntityRepository;
    }

    public UserEntityDTO findByUsername(String username) {
        UserEntity userEntity = userEntityRepository.findByUsernameAndIsActive(username, true)
                .orElseThrow(() -> new RuntimeException("User not found!"));

        return MapperUserEntity.UserEntityToUserEntityDTO(userEntity);
    }

    public UserEntity findByEmail(String email) {
        UserEntity userEntity = userEntityRepository.findByEmailAndIsActiveTrue(email, true)
                .orElseThrow(() -> new RuntimeException("Email not found!"));

        return userEntity;
    }

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {

        try{
            UserEntity userEntity = findByEmail(email);

            return User.builder()
                    .username(userEntity.getEmail())
                    .password(userEntity.getPassword())
                    .roles("USER")
                    .build();

        } catch (UsernameNotFoundException ex){
            throw new UsernameNotFoundException("email not found: " + email);
        }
    }
}
