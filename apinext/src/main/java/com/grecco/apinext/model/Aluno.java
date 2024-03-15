package com.grecco.apinext.model;

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
    private String observacao;
    private String email;
    @Setter(AccessLevel.NONE)
    private LocalDate dataCadastro;
    @OneToOne
    private Plano plano;
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
