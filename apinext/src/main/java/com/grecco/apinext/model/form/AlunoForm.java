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
    private String observacao;
    private String email;

    public AlunoForm(String nome, String email) {
        this.nome = nome;
        this.email = email;
    }
}
