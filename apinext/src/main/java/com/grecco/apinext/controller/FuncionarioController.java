package com.grecco.apinext.controller;

import com.grecco.apinext.model.Funcionario;
import com.grecco.apinext.model.form.FuncionarioForm;
import com.grecco.apinext.service.FuncionarioService;
import com.grecco.apinext.service.PessoaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
@RequestMapping("/funcionario")
public class FuncionarioController {

    private final FuncionarioService service;
    private final PessoaService pessoaService;

    @Autowired
    public FuncionarioController(FuncionarioService funcionarioService,
                                 PessoaService pessoaService) {
        this.service = funcionarioService;
        this.pessoaService = pessoaService;
    }


    @PostMapping("/")
    public ResponseEntity<String> salvar(@RequestBody FuncionarioForm form) {
        try {
            pessoaService.pessoaValidate(form.getCpf());
            service.builder(form);
           return ResponseEntity.ok("Novo funcionario Salvo!");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("Erro ao criar Funcionario: " + e.getMessage());
        }
    }
}
