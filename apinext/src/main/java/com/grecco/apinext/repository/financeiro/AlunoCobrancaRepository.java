package com.grecco.apinext.repository.financeiro;

import com.grecco.apinext.model.financeiro.AlunoCobranca;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AlunoCobrancaRepository extends JpaRepository<AlunoCobranca, Integer> {
}
