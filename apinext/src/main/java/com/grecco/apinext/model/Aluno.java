package com.grecco.apinext.model;

import com.grecco.apinext.model.enums.TipoPlano;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "aluno")
public class Aluno {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Enumerated(EnumType.STRING)
    private TipoPlano plano;
    private LocalDate vencimento;
    private Boolean vencido;
    private String observacao;
    private String email;
    private String planoMutavel;
    @Setter(AccessLevel.NONE)
    private LocalDate dataCadastro;
    @OneToOne
    @JoinColumn(name = "pessoa_id", referencedColumnName = "id")
    private Pessoa pessoa;
    @OneToMany
    private List<Agendamento> agendamento;


    @PrePersist
    public void setDataCadastro() {
        if (dataCadastro == null || dataCadastro.isAfter(LocalDate.now())) {
            dataCadastro = LocalDate.now();
        }
    }
}
