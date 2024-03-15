package com.grecco.apinext.controller;

import com.grecco.apinext.model.form.PlanoForm;
import com.grecco.apinext.service.PlanoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/plano")
public class PlanoController {


    private final PlanoService planoService;

    @Autowired
    PlanoController(PlanoService service) {
        planoService = service;
    }

    @PostMapping("/")
    public ResponseEntity<String> salvar(@RequestBody PlanoForm form) {
        try {
            planoService.builderPlano(form);
            return ResponseEntity.ok("Novo Plano Salvo!");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("Erro ao criar Plano: " + e.getMessage());
        }
    }
}
