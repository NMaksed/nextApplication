package com.grecco.apinext.service;

import com.grecco.apinext.model.Funcionario;
import com.grecco.apinext.model.Pessoa;
import com.grecco.apinext.model.form.FuncionarioForm;
import com.grecco.apinext.repository.FuncionarioRepository;
import com.grecco.apinext.repository.PessoaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FuncionarioService {

    private final FuncionarioRepository funcionarioRepository;
    private final PessoaService pessoaService;

    @Autowired
    public FuncionarioService(FuncionarioRepository repository,
                              PessoaService pessoaService) {
        this.funcionarioRepository = repository;
        this.pessoaService = pessoaService;
    }

    public void builder(FuncionarioForm form) {
        Pessoa pessoa = Pessoa.builder()
                .nome(form.getNome())
                .rg(form.getRg())
                .cpf(form.getCpf())
                .cep(form.getCep())
                .dataNascimento(form.getDataNascimento())
                .build();
        Funcionario funcionario = Funcionario.builder()
                .pessoa(pessoa)
                .salario(form.getSalario())
                .pagamento(form.getPagamento())
                .build();
        pessoaService.salvar(pessoa);
        salvar(funcionario);
    }

    public void salvar(Funcionario funcionario) {
        funcionarioRepository.save(funcionario);
    }
}
