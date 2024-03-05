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
    @Query("SELECT NEW com.grecco.apinext.model.form.AlunoForm(a.plano, a.dataCadastro, a.pessoa.nome, a.vencido, a.email) FROM Aluno a " +
            "WHERE (:#{#filtro.plano} IS NULL OR a.plano = :#{#filtro.plano}) " +
            "AND (:#{#filtro.dataCadastro} IS NULL OR a.dataCadastro <= :#{#filtro.dataCadastro}) " +
            "AND (:#{#filtro.nome} IS NULL OR a.pessoa.nome = :#{#filtro.nome}) " +
            "AND (:#{#filtro.vencido} IS NULL OR a.vencido = :#{#filtro.vencido})")
    List<AlunoForm> findAlunoByFiltro(@Param("filtro") AlunoFilter filtro);

}
