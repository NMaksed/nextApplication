package com.grecco.apinext.model.enums;

import lombok.Getter;

@Getter
public enum TipoPlano {

    MENSAL_2X("Mensal 2 vez na Semana", 201.00),
    MENSAL_3X("Mensal 3 vez na Semana", 422.00),
    MENSAL_5X("Mensal 3 vez na Semana", 503.00),
    ANUAL_2X("Anual 2 vez na Semana", 201.0),
    ANUAL_3X("Anual 3 vez na Semanal", 233.0),
    ANUAL_5X("Anual 5 vez na Semana", 282.0),
    SEMESTRAL_2X("Semestral 2 vez na Semana", 224.0),
    SEMESTRAL_3X("Semestral 3 vez na Semana", 260.0),
    SEMESTRAL_5X("Semestral 5 vez na Semana", 314.0),
    TRIMESTRAL_2X("Trimestral 2 vez na Semana", 251.0),
    TRIMESTRAL_3X("Trimestral 3 vez na Semana", 291.0),
    TRIMESTRAL_5X("Trimestral 5 vez na Semana", 395.0);


    private String descricao;
    private Double preco;

    TipoPlano(String descricao, Double preco) {
        this.descricao = descricao;
        this.preco = preco;
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
