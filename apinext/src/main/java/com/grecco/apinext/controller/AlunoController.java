package com.grecco.apinext.controller;

import com.grecco.apinext.model.Aluno;
import com.grecco.apinext.model.filters.AlunoFilter;
import com.grecco.apinext.model.form.AlunoForm;
import com.grecco.apinext.service.AlunoService;
import com.grecco.apinext.service.PessoaService;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/aluno")
public class AlunoController {

    private final AlunoService alunoService;
    private final PessoaService pessoaService;

    @Autowired
    public AlunoController(AlunoService service,
                           PessoaService pessoaService) {
        this.alunoService = service;
        this.pessoaService = pessoaService;
    }

    @PostMapping("/")
    public ResponseEntity<String> salvar(@RequestBody AlunoForm form) {
        try {
            pessoaService.pessoaValidate(form.getCpf());
            alunoService.builder(form);
            return ResponseEntity.ok("Novo aluno Adicionado!");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("Erro ao criar Funcionario: " + e.getMessage());
        }
    }

    @GetMapping("/pesquisar")
    public List<Aluno> pesquisarTodos() {
        return alunoService.pesquisarTodos();
    }

    @GetMapping("/pesquisarComFiltro")
    public ResponseEntity<List<AlunoForm>> pesquisarComFiltro(
            @RequestBody AlunoFilter filtro) {
        List<AlunoForm> form = alunoService.pesquisarComFiltro(filtro);
        return new ResponseEntity<>(form, HttpStatus.OK);
    }

}
