package com.sytem.financeiropersonal.dto;

import com.sytem.financeiropersonal.model.Entrada;

import java.time.LocalDate;
import java.util.Date;

public record EntradaDTOCreate(
        String dataEntrada,
        String descricao,
        Double valor
) {
    public EntradaDTOCreate (
            String dataEntrada,
            String descricao,
            Double valor
    ) {
        this.dataEntrada = dataEntrada;
        this.descricao = descricao;
        this.valor = valor;
    }

    public EntradaDTOCreate(
            Entrada entrada
    ){
        this(
                entrada.getDataEntrada(),
                entrada.getDescricao(),
                entrada.getValor()
        );
    }
}
