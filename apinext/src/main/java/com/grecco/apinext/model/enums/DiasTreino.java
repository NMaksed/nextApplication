package com.grecco.apinext.model.enums;

import lombok.Getter;

@Getter
public enum DiasTreino {

    SEGUNDA("Segunda"),
    TERCA("Terça"),
    QUARTA("Quarta"),
    QUINTA("Quinta"),
    SEXTA("Sexta");

    private String descricao;

    DiasTreino(String descricao) {
        this.descricao = descricao;
    }

    public static DiasTreino fromDescricao(String descricao) {
        for (DiasTreino diasTreino : DiasTreino.values()) {
            if (diasTreino.getDescricao().equalsIgnoreCase(descricao)) {
                return diasTreino;
            }
        }
        throw new IllegalArgumentException("Descrição inválida para diasTreino: " + descricao);
    }
}
