package com.grecco.apinext.model.enums;

import lombok.Getter;

@Getter
public enum TipoPlano {
    MENSAL("Mensal"),
    TRIMESTRAL("Trimestral"),
    SEMESTRAL("Semestral"),
    ANUAL("Anual");

    private String descricao;

    TipoPlano(String descricao) {
        this.descricao = descricao;
    }

    public static TipoPlano fromDescricao(String descricao) {
        for (TipoPlano tipoPlano : TipoPlano.values()) {
            if (tipoPlano.getDescricao().equalsIgnoreCase(descricao)) {
                return tipoPlano;
            }
        }
        throw new IllegalArgumentException("Descrição inválida para TipoPlano: " + descricao);
    }
}
