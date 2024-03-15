package com.grecco.apinext.model.enums;

import lombok.Getter;

@Getter
public enum FormaPagamento {

    CREDITO("Crédito"),
    DEBITO("Débito"),
    BOLETO("Boleto"),
    PIX("Pix"),
    DINHEIRO("Dinheiro");

    private String descricao;

    FormaPagamento(String descricao) {
        this.descricao = descricao;
    }
}
