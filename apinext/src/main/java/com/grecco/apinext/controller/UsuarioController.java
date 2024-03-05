package com.grecco.apinext.controller;

import com.grecco.apinext.model.form.UsuarioForm;
import com.grecco.apinext.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
@RequestMapping("/usuario")
public class UsuarioController {

    public final UsuarioService usuarioService;

    @Autowired
    public UsuarioController(UsuarioService usuarioService) {
        this.usuarioService = usuarioService;
    }


    @PostMapping("/login")
    public ResponseEntity<String> validateUsuario(@RequestBody UsuarioForm form) {
        try {
            if (usuarioService.validateLogin(form.getEmail(), form.getSenha())) {
                return ResponseEntity.ok("FireBase!");
            }
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("Erro ao criar Funcionario: " + e.getMessage());
        }
        return null;
    }

}
