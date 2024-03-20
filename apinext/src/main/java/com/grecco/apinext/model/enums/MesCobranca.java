package com.grecco.apinext.model.enums;

import lombok.Getter;

@Getter
public enum MesCobranca {

    JANEIRO("Janeiro", 1),
    FEVEREIRO("Fevereiro", 2),
    MARCO("Março", 3),
    ABRIL("Abril", 4),
    MAIO("Maio", 5),
    JUNHO("Junho", 6),
    JULHO("Julho", 7),
    AGOSTO("Agosto", 8),
    SETEMBRO("Setembro", 9),
    OUTUBRO("Outubro", 10),
    NOVEMBRO("Novembro", 11),
    DEZEMBRO("Dezembro", 12);

    private String descricao;
    private Integer numeroMes;
    MesCobranca(String descricao, Integer numeroMes) {
        this.descricao = descricao;
        this.numeroMes = numeroMes;
    }


    public static MesCobranca fromNumber(int number) {
        for (MesCobranca month : MesCobranca.values()) {
            if (month.getNumeroMes() == number) {
                return month;
            } else if (number > 12) {
                int anoReiniciado = number - 12;
                if (month.getNumeroMes() == anoReiniciado) {
                    return month;
                }
            }
        }
        throw new IllegalArgumentException("Invalid month number: " + number);
    }
}
