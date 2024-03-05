package com.grecco.apinext.model;

import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "empresa")
public class Empresa {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String nome;
    private String cnpj;
    private String uf;
    private String cep;
    private String cidade;
    private String rua;
    private Integer numero;
    @Transient
    @Getter(AccessLevel.NONE)
    private String enderecoCompleto;

    public String getEnderecoCompleto() {
        if (getRua() != null && getNumero() != null && getCidade() != null &&
                getUf() != null && getCep() != null) {
            StringBuilder stb = new StringBuilder();
            stb.append(getRua()).append(", ").append(getNumero()).append(" - ")
                    .append(getCidade()).append(", ").append(getUf()).append(" - ").append(getCep());
            return enderecoCompleto = String.valueOf(stb);
        }
        return null;
    }

}
