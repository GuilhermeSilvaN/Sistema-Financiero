package com.sytem.financeiropersonal.mapper;

import com.sytem.financeiropersonal.dto.EntradaDTO;
import com.sytem.financeiropersonal.dto.EntradaDTOCreate;
import com.sytem.financeiropersonal.model.Entrada;

public class MapperEntrada {
    public static Entrada entradaDTOCreateToEntrada (EntradaDTOCreate entradaDTOCreate){
        return new Entrada(
                entradaDTOCreate.dataEntrada(),
                entradaDTOCreate.descricao(),
                entradaDTOCreate.valor()
        );
    }

    public static EntradaDTO entradaToEntradaDTO (Entrada entrada){
        return new EntradaDTO(
                entrada.getId(),
                entrada.getDataEntrada(),
                entrada.getDescricao(),
                entrada.getValor()
        );
    }

    public static EntradaDTOCreate EntradaToEntradaDTOCreate (Entrada entrada){
        return new EntradaDTOCreate(
                entrada.getDataEntrada(),
                entrada.getDescricao(),
                entrada.getValor()
        );
    }

    public static void updateEntrada(Entrada entrada, EntradaDTOCreate entradaDTOCreate){
        entrada.setDataEntrada(entradaDTOCreate.dataEntrada());
        entrada.setDescricao(entradaDTOCreate.descricao());
        entrada.setValor(entradaDTOCreate.valor());
    }
}
