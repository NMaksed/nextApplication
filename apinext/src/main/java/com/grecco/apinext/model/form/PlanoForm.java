package com.grecco.apinext.model.form;

import com.grecco.apinext.model.enums.TipoPlano;
import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
public class PlanoForm {

    private Double valor;
    private String descricao;
    private TipoPlano plano;
}
