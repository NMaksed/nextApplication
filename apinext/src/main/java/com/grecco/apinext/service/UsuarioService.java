package com.grecco.apinext.service;

import com.grecco.apinext.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UsuarioService {

    public final UsuarioRepository usuarioRepository;

    @Autowired
    public UsuarioService(UsuarioRepository usuarioRepository) {
        this.usuarioRepository = usuarioRepository;
    }

    public boolean validateLogin(String email, String senha) {
        if (usuarioRepository.validateUserLogin(email, senha) > 0) {
            return true;
        }
        return false;
    }
}
