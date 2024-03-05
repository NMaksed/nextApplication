package com.grecco.apinext.service;

import com.grecco.apinext.model.Pessoa;
import com.grecco.apinext.repository.PessoaRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class PessoaService {

    private final PessoaRepository pessoaRepository;

    public PessoaService(PessoaRepository repository) {
        this.pessoaRepository = repository;
     }

    public void salvar(Pessoa pessoa) {
        pessoaRepository.save(pessoa);
    }

    public void pessoaValidate(String cpf) throws Exception{
        Optional<Pessoa> pessoaOptionals = pessoaRepository.findByCpf(cpf);

        if (pessoaOptionals.isPresent()) {
            throw new Exception("Cpf: " + cpf + "já cadastrado");
        }
    }
}
