package com.sytem.financeiropersonal.dto;

import com.sytem.financeiropersonal.model.Despesa;

import java.time.LocalDate;
import java.util.Date;

public record DespesaDTO(
        Long id,
        String dataDespesa,
        String descricao,
        String categoria,
        String formaPagamento,
        Double valor
) {
    public DespesaDTO(
            Long id, String dataDespesa, String  descricao, String categoria, String formaPagamento, Double valor
    ){
        this.id = id;
        this.dataDespesa = dataDespesa;
        this.descricao = descricao;
        this.categoria = categoria;
        this.formaPagamento = formaPagamento;
        this.valor = valor;
    }

    public DespesaDTO(
            Despesa despesa
    ){
        this(
                despesa.getId(),
                despesa.getDataDespesa(),
                despesa.getDescricao(),
                despesa.getCategoria(),
                despesa.getFormaPagamento(),
                despesa.getValor()
        );
    }
}
