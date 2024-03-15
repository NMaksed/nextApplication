package com.grecco.apinext.service;

import com.grecco.apinext.model.Plano;
import com.grecco.apinext.model.enums.TipoPlano;
import com.grecco.apinext.model.form.PlanoForm;
import com.grecco.apinext.repository.PlanoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PlanoService {

    private final PlanoRepository planoRepository;

    @Autowired
    PlanoService(PlanoRepository repository) {
        planoRepository = repository;
    }

    public void salvarPlano(Plano plano) {
        planoRepository.save(plano);
    }

    public void builderPlano(PlanoForm form) {
        Plano plano = Plano.builder()
                .valor(form.getValor())
                .descricao(form.getDescricao())
                .tipo(TipoPlano.fromDescricao(form.getPlano().getDescricao()))
                .build();
        salvarPlano(plano);
    }

    public Plano pesquisarPlanoPorAluno(Integer aluno) {
        return planoRepository.pesquisarPlano(aluno);
    }
}
