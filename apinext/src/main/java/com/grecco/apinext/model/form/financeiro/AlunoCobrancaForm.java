package com.grecco.apinext.model.form.financeiro;

import com.grecco.apinext.model.Aluno;
import com.grecco.apinext.model.Plano;
import com.grecco.apinext.model.enums.FormaPagamento;
import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
public class AlunoCobrancaForm {

    private Integer aluno;
    private FormaPagamento formaPagamento;
}
