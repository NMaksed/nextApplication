package com.grecco.apinext.repository;

import com.grecco.apinext.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface UsuarioRepository extends JpaRepository<Usuario, Integer> {

    @Query(value = "SELECT 1 FROM usuario u WHERE u.email = ?1 and u.senha = ?2", nativeQuery = true)
    Integer validateUserLogin(String email, String senha);
}
