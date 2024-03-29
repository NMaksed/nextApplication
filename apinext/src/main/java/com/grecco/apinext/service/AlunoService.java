package com.grecco.apinext.service;

import com.grecco.apinext.model.Aluno;
import com.grecco.apinext.model.Pessoa;
import com.grecco.apinext.model.filters.AlunoFilter;
import com.grecco.apinext.model.form.AlunoForm;
import com.grecco.apinext.repository.AlunoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.swing.text.html.Option;
import java.util.List;
import java.util.Optional;

@Service
public class AlunoService {

    private final AlunoRepository alunoRepository;

    @Autowired
    public AlunoService(AlunoRepository repository) {
        this.alunoRepository = repository;
    }

    public void salvar(Aluno aluno) {
        alunoRepository.save(aluno);
    }

    public void builder(AlunoForm form) {
        Pessoa pessoa = Pessoa.builder()
                .nome(form.getNome())
                .rg(form.getRg())
                .cpf(form.getCpf())
                .cep(form.getCep())
                .dataNascimento(form.getDataNascimento())
                .build();
        Aluno aluno = Aluno
                .builder()
                .email(form.getEmail())
                .observacao(form.getObservacao())
                .pessoa(pessoa)
                .build();
        salvar(aluno);
    }

    public List<Aluno> pesquisarTodos() {
        return alunoRepository.findAll();
    }

    public List<AlunoForm> pesquisarComFiltro(AlunoFilter filtro) {
        return alunoRepository.findAlunoByFiltro(filtro);
    }

    public Aluno pesquisarAlunoById(Integer id) {
        return alunoRepository.pesquisarPorId(id);
    }
}
