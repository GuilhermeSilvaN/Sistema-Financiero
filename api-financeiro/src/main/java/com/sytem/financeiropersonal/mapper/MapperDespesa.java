package com.sytem.financeiropersonal.mapper;

import com.sytem.financeiropersonal.dto.DespesaDTO;
import com.sytem.financeiropersonal.dto.DespesaDTOCreate;
import com.sytem.financeiropersonal.model.Despesa;

public class MapperDespesa {
    public static Despesa despesaDTOCreateToDespesa(DespesaDTOCreate despesaDTOCreate) {
        return new Despesa(
                despesaDTOCreate.dataDespesa(),
                despesaDTOCreate.descricao(),
                despesaDTOCreate.categoria(),
                despesaDTOCreate.formaPagamento(),
                despesaDTOCreate.valor()
        );
    }

    public static DespesaDTO despesaToDespesaDTO(Despesa despesa) {
        return new DespesaDTO(
                despesa.getId(),
                despesa.getDataDespesa(),
                despesa.getDescricao(),
                despesa.getCategoria(),
                despesa.getFormaPagamento(),
                despesa.getValor()
        );
    }

    public static DespesaDTOCreate despesaToDespesaDTOCreate(Despesa despesa) {
        return new DespesaDTOCreate(
                despesa.getDataDespesa(),
                despesa.getDescricao(),
                despesa.getCategoria(),
                despesa.getFormaPagamento(),
                despesa.getValor()
        );
    }

    public static void updateDespesa(Despesa despesa, DespesaDTOCreate despesaDTOCreate) {
        despesa.setDataDespesa(despesaDTOCreate.dataDespesa());
        despesa.setDescricao(despesaDTOCreate.descricao());
        despesa.setCategoria(despesaDTOCreate.categoria());
        despesa.setFormaPagamento(despesaDTOCreate.formaPagamento());
        despesa.setValor(despesaDTOCreate.valor());
    }
}
