package com.grecco.apinext.service.financeiro;

import com.grecco.apinext.model.Aluno;
import com.grecco.apinext.model.Plano;
import com.grecco.apinext.model.enums.TipoPlano;
import com.grecco.apinext.model.financeiro.AlunoCobranca;
import com.grecco.apinext.model.form.financeiro.AlunoCobrancaForm;
import com.grecco.apinext.repository.financeiro.AlunoCobrancaRepository;
import com.grecco.apinext.service.AlunoService;
import com.grecco.apinext.service.PlanoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AlunoCobrancaService {

    private final AlunoCobrancaRepository alunoCobrancaRepository;
    private final AlunoService alunoService;
    private final PlanoService planoService;

    @Autowired
    AlunoCobrancaService(AlunoCobrancaRepository alunoCobrancaRepository, AlunoService alunoService, PlanoService planoService) {
        this.alunoCobrancaRepository = alunoCobrancaRepository;
        this.alunoService = alunoService;
        this.planoService = planoService;
    }


    public void gerarCobrancas(AlunoCobrancaForm form) {
        Aluno aluno = alunoService.pesquisarAlunoById(form.getAluno());
        Plano plano = planoService.pesquisarPlanoPorAluno(form.getAluno());
        AlunoCobranca alunoCobranca = AlunoCobranca.builder()
                .aluno(aluno)
                .plano(plano)
                .valorCobranca(plano.getValor())
                .build();
            if (plano.getTipo().equals(TipoPlano.MENSAL)) {
                alunoCobrancaRepository.save(alunoCobranca);
            }
            else if (plano.getTipo().equals(TipoPlano.TRIMESTRAL)) {
                gerarCobrancaTrimestral(alunoCobranca);
            }
            else if (plano.getTipo().equals(TipoPlano.SEMESTRAL)) {
                gerarCobrancaSemestral(alunoCobranca);
            }
            else if (plano.getTipo().equals(TipoPlano.ANUAL)) {
                gerarCobrancaAnual(alunoCobranca);
            }
    }

    public void gerarCobrancaTrimestral(AlunoCobranca cobranca) {
        for (int i = 0; i <= 2; i++) {
            AlunoCobranca alunoCobranca = AlunoCobranca.builder()
                    .valorCobranca(cobranca.getValorCobranca())
                    .aluno(cobranca.getAluno())
                    .plano(cobranca.getPlano())
                    .pago(false)
                    .build();
            alunoCobrancaRepository.save(alunoCobranca);
        }
    }
    public void gerarCobrancaSemestral(AlunoCobranca cobranca) {
        for (int i = 0; i <= 5; i++) {
            AlunoCobranca alunoCobranca = AlunoCobranca.builder()
                    .valorCobranca(cobranca.getValorCobranca())
                    .aluno(cobranca.getAluno())
                    .plano(cobranca.getPlano())
                    .pago(false)
                    .build();
            alunoCobrancaRepository.save(alunoCobranca);
        }
    }
    public void gerarCobrancaAnual(AlunoCobranca cobranca) {
        for (int i = 0; i <= 11; i++) {
            AlunoCobranca alunoCobranca = AlunoCobranca.builder()
                    .valorCobranca(cobranca.getValorCobranca())
                    .aluno(cobranca.getAluno())
                    .plano(cobranca.getPlano())
                    .pago(false)
                    .build();
            alunoCobrancaRepository.save(alunoCobranca);
        }
    }
}
