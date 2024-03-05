package com.grecco.apinext.model.filters;

import com.grecco.apinext.model.Pessoa;
import com.grecco.apinext.model.enums.TipoPlano;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class AlunoFilter {

    private TipoPlano plano;
    private String nome;
    private LocalDate vencimento;
    private Boolean vencido;
    private String email;
    private LocalDate dataCadastro;
}
