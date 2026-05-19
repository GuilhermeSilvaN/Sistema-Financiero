package com.sytem.financeiropersonal.controller;

import com.sytem.financeiropersonal.dto.LoginDTO;
import com.sytem.financeiropersonal.dto.LoginResponseDTO;
import com.sytem.financeiropersonal.dto.UserEntityDTO;
import com.sytem.financeiropersonal.dto.UserEntityDTOCreate;
import com.sytem.financeiropersonal.mapper.MapperUserEntity;
import com.sytem.financeiropersonal.model.UserEntity;
import com.sytem.financeiropersonal.repository.UserEntityRepository;
import com.sytem.financeiropersonal.service.JwtService;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/login")
public class AuthController {

    private final UserEntityRepository userEntityRepository;
    private final PasswordEncoder passwordEncoder;
    private final AuthenticationManager authenticationManager;
    private final JwtService jwtService;

    public AuthController (
            UserEntityRepository userEntityRepository,
            PasswordEncoder passwordEncoder,
            AuthenticationManager authenticationManager,
            JwtService jwtService
    ) {
        this.userEntityRepository = userEntityRepository;
        this.passwordEncoder = passwordEncoder;
        this.authenticationManager = authenticationManager;
        this.jwtService = jwtService;
    }

    @PostMapping
    public ResponseEntity<?> login (@RequestBody LoginDTO data){
        try{
            //cria o token de autenticacao (email + senha)
            var authToken = new UsernamePasswordAuthenticationToken(
                    data.email(),
                    data.password()
            );

            //autentica (spring valida automaticamente)
            Authentication authentication = authenticationManager.authenticate(authToken);

            // pega o usuario autenticado
            String email = authToken.getName();

            UserEntity userEntity = userEntityRepository.findByEmailAndIsActiveTrue(email, true);

            //gera o jwt;
            String token = jwtService.generateToken(email);

            LoginResponseDTO response = new LoginResponseDTO(
                    token,
                    userEntity.getId(),
                    userEntity.getUsername()
            );

            //retorn response;
            return ResponseEntity.ok().body(response);
        } catch (Exception ex){
            return ResponseEntity.status(401).body(" ==== error no login: ==== " + ex.getMessage());
        }
    }

    @PostMapping("/register")
    public ResponseEntity<UserEntityDTO> registerUser(@RequestBody UserEntityDTOCreate userCreate){
        UserEntity userEntity = MapperUserEntity.UserEntityDTOCreateToUserEntity(userCreate);
        userEntity.setPassword(passwordEncoder.encode(userCreate.password()));

        userEntityRepository.save(userEntity);

        return ResponseEntity.ok().body(MapperUserEntity.UserEntityToUserEntityDTO(userEntity));
    }

    @GetMapping
    public ResponseEntity<String> hello(){
        return ResponseEntity.ok().body(" ==== Hello World! ===");
    }


}
