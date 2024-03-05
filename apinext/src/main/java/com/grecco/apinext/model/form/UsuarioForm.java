package com.grecco.apinext.model.form;

import lombok.*;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class UsuarioForm {

    public String email;
    public String senha;
}
