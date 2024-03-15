package com.grecco.apinext.controller.financeiro;

import com.grecco.apinext.model.form.financeiro.AlunoCobrancaForm;
import com.grecco.apinext.service.financeiro.AlunoCobrancaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/cobranca")
public class AlunoCobrancaController {

    private final AlunoCobrancaService alunoCobrancaService;

    @Autowired
    AlunoCobrancaController(AlunoCobrancaService service) {
        alunoCobrancaService = service;
    }

    @PostMapping("/")
    public ResponseEntity<String> salvar(@RequestBody AlunoCobrancaForm form) {
        try {
            alunoCobrancaService.gerarCobrancas(form);
            return ResponseEntity.ok("Nova cobrança gerada!");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("Erro ao criar Funcionario: " + e.getMessage());
        }
    }
}
