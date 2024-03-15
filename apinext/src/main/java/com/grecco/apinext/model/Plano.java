package com.grecco.apinext.model;

import com.grecco.apinext.model.enums.TipoPlano;
import jakarta.persistence.*;
import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
@Entity
@Table(name = "plano")
public class Plano {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private Double valor;
    private String descricao;
    @Enumerated(EnumType.STRING)
    private TipoPlano tipo;
}
