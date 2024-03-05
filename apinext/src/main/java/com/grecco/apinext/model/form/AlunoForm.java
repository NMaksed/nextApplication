package com.grecco.apinext.model.form;

import com.grecco.apinext.model.enums.TipoPlano;
import lombok.*;

import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class AlunoForm {

    private String nome;
    private String rg;
    private String cpf;
    private String cep;
    private LocalDate dataNascimento;
    private TipoPlano plano;
    private LocalDate vencimento;
    private Boolean vencido;
    private String observacao;
    private String email;
    private String planoMutavel;

    public AlunoForm(TipoPlano plano, LocalDate vencimento, String nome, Boolean vencido, String email) {
        this.plano = plano;
        this.vencimento = vencimento;
        this.nome = nome;
        this.vencido = vencido;
        this.email = email;

    }
}
