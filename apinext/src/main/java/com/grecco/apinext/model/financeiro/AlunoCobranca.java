package com.grecco.apinext.model.financeiro;

import com.grecco.apinext.model.Aluno;
import com.grecco.apinext.model.Plano;
import com.grecco.apinext.model.enums.FormaPagamento;
import com.grecco.apinext.model.enums.MesCobranca;
import jakarta.persistence.*;
import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
@Entity
@Table(name = "alunocobranca")
public class AlunoCobranca {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @OneToOne
    private Plano plano;
    @ManyToOne
    private Aluno aluno;
    private Double valorCobranca;
    private Boolean pago = false; //TODO: pago caso seja cartão
    private Boolean cancelado = false;
    private String formaPagamento;
    private String mesCobranca;
    private Integer numeroParcela;
    //TODO: notificação ultimo mes parcela
}
