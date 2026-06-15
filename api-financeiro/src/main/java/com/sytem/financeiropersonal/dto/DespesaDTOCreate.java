package com.sytem.financeiropersonal.dto;

import com.sytem.financeiropersonal.model.Despesa;

import java.time.LocalDate;
import java.util.Date;

public record DespesaDTOCreate(
        LocalDate dataDespesa,
        String descricao,
        String categoria,
        String formaPagamento,
        Double valor
) {
    public DespesaDTOCreate(
            LocalDate dataDespesa, String  descricao, String categoria, String formaPagamento, Double valor
    ){
        this.dataDespesa = dataDespesa;
        this.descricao = descricao;
        this.categoria = categoria;
        this.formaPagamento = formaPagamento;
        this.valor = valor;
    }

    public DespesaDTOCreate(
            Despesa despesa
    ){
        this(
                despesa.getDataDespesa(),
                despesa.getDescricao(),
                despesa.getCategoria(),
                despesa.getFormaPagamento(),
                despesa.getValor()
        );
    }
}
