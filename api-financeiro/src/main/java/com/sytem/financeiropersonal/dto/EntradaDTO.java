package com.sytem.financeiropersonal.dto;

import com.sytem.financeiropersonal.model.Entrada;

import java.util.Date;

public record EntradaDTO(
        Long id,
        Date dataEntrada,
        String descricao,
        Double valor
) {
    public EntradaDTO (
            Long id,
            Date dataEntrada,
            String descricao,
            Double valor
    ) {
        this.id = id;
        this.dataEntrada = dataEntrada;
        this.descricao = descricao;
        this.valor = valor;
    }

    public EntradaDTO(
            Entrada entrada
    ){
        this(
                entrada.getId(),
                entrada.getDataEntrada(),
                entrada.getDescricao(),
                entrada.getValor()
        );
    }
}
