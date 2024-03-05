package com.grecco.apinext.model.form;

import lombok.*;

import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class FuncionarioForm {

    private String nome;
    private String cpf;
    private String rg;
    private String cep;
    private LocalDate dataNascimento;
    private Double salario;
    private LocalDate pagamento;
}
