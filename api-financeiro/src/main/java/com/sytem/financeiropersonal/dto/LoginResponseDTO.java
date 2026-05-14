package com.sytem.financeiropersonal.dto;

public record LoginResponseDTO(
        String token,
        Long id,
        String username
) {
}
