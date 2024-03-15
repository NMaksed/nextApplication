package com.grecco.apinext.model.form.financeiro;

import com.grecco.apinext.model.Aluno;
import com.grecco.apinext.model.Plano;
import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
public class AlunoCobrancaForm {

    private Integer plano;
    private Integer aluno;
}
