package com.grecco.apinext.model.enums;

import lombok.Getter;

@Getter
public enum StatusPagamento {

    PAGO("Pago"),
    EM_ABERTO("Aberto"),
    ATRASADO("Atrasado");

    private String descricao;

    StatusPagamento(String descricao) {
        this.descricao = descricao;
    }
}
