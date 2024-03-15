package com.grecco.apinext.repository;

import com.grecco.apinext.model.Aluno;
import com.grecco.apinext.model.filters.AlunoFilter;
import com.grecco.apinext.model.form.AlunoForm;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface AlunoRepository extends JpaRepository<Aluno, Integer> {


    /**
     *  PESQUISAR: JPAQueryFactory
     * @param filtro
     * @return
     */
    @Query("SELECT NEW com.grecco.apinext.model.form.AlunoForm(a.pessoa.nome, a.email) FROM Aluno a " +
            "WHERE (:#{#filtro.nome} IS NULL OR a.pessoa.nome = :#{#filtro.nome})" +
            "AND (:#{#filtro.email} IS NULL OR a.email = :#{#filtro.email})")
    List<AlunoForm> findAlunoByFiltro(@Param("filtro") AlunoFilter filtro);

    @Query(value = "SELECT * FROM aluno a WHERE a.id = :id", nativeQuery = true)
    Aluno pesquisarPorId(@Param("id") Integer id);

}
