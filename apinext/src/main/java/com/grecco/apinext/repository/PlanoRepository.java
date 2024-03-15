package com.grecco.apinext.repository;

import com.grecco.apinext.model.Plano;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface PlanoRepository extends JpaRepository<Plano, Integer> {

    @Query(value = "SELECT p.* FROM plano p LEFT JOIN aluno a ON a.plano_id = p.id WHERE a.id = :aluno", nativeQuery = true)
    Plano pesquisarPlano(@Param("aluno") Integer aluno);
}
