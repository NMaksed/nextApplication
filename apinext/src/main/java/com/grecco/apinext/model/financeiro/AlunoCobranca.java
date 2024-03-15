package com.grecco.apinext.model.financeiro;

import com.grecco.apinext.model.Aluno;
import com.grecco.apinext.model.Plano;
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
    private Boolean pago = false;

}
