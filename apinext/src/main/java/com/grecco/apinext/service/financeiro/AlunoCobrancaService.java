package com.grecco.apinext.service.financeiro;

import com.grecco.apinext.model.Aluno;
import com.grecco.apinext.model.Plano;
import com.grecco.apinext.model.enums.MesCobranca;
import com.grecco.apinext.model.enums.TipoPlano;
import com.grecco.apinext.model.financeiro.AlunoCobranca;
import com.grecco.apinext.model.form.financeiro.AlunoCobrancaForm;
import com.grecco.apinext.repository.financeiro.AlunoCobrancaRepository;
import com.grecco.apinext.service.AlunoService;
import com.grecco.apinext.service.PlanoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cglib.core.Local;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.Calendar;

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
        int numeroMes = LocalDate.now().getMonthValue();

        AlunoCobranca alunoCobranca = AlunoCobranca.builder()
                .aluno(aluno)
                .plano(plano)
                .valorCobranca(plano.getValor())
                .mesCobranca(MesCobranca.fromNumber(numeroMes).getDescricao())
                .cancelado(false)
                .pago(false)
                .numeroParcela(1)
                .formaPagamento(form.getFormaPagamento().getDescricao())
                .build();
            if (plano.getTipo().equals(TipoPlano.MENSAL)) {
                alunoCobrancaRepository.save(alunoCobranca);
            }
            else if (plano.getTipo().equals(TipoPlano.TRIMESTRAL)) {
                gerarCobrancaTrimestral(alunoCobranca, numeroMes);
            }
            else if (plano.getTipo().equals(TipoPlano.SEMESTRAL)) {
                gerarCobrancaSemestral(alunoCobranca, numeroMes);
            }
            else if (plano.getTipo().equals(TipoPlano.ANUAL)) {
                gerarCobrancaAnual(alunoCobranca, numeroMes);
            }
    }

    public void gerarCobrancaTrimestral(AlunoCobranca cobranca, int numeroMes) {
        for (int i = 0; i <= 2; i++) {
            MesCobranca mesAtual = MesCobranca.fromNumber(numeroMes);
            AlunoCobranca alunoCobranca = AlunoCobranca.builder()
                    .valorCobranca(cobranca.getValorCobranca())
                    .aluno(cobranca.getAluno())
                    .plano(cobranca.getPlano())
                    .pago(false)
                    .mesCobranca(mesAtual.getDescricao())
                    .cancelado(false)
                    .numeroParcela(cobranca.getNumeroParcela())
                    .formaPagamento(cobranca.getFormaPagamento())
                    .build();
            cobranca.setNumeroParcela(cobranca.getNumeroParcela() + 1);
            numeroMes += 1;
            alunoCobrancaRepository.save(alunoCobranca);
        }
    }
    public void gerarCobrancaSemestral(AlunoCobranca cobranca, int numeroMes) {
        for (int i = 0; i <= 5; i++) {
            MesCobranca mesAtual = MesCobranca.fromNumber(numeroMes);
            AlunoCobranca alunoCobranca = AlunoCobranca.builder()
                    .valorCobranca(cobranca.getValorCobranca())
                    .aluno(cobranca.getAluno())
                    .plano(cobranca.getPlano())
                    .pago(false)
                    .mesCobranca(mesAtual.getDescricao())
                    .cancelado(false)
                    .numeroParcela(cobranca.getNumeroParcela())
                    .formaPagamento(cobranca.getFormaPagamento())
                    .build();
            cobranca.setNumeroParcela(cobranca.getNumeroParcela() + 1);
            numeroMes += 1;
            alunoCobrancaRepository.save(alunoCobranca);
        }
    }
    public void gerarCobrancaAnual(AlunoCobranca cobranca, int numeroMes) {
        for (int i = 0; i <= 11; i++) {
            MesCobranca mesAtual = MesCobranca.fromNumber(numeroMes);
            AlunoCobranca alunoCobranca = AlunoCobranca.builder()
                    .valorCobranca(cobranca.getValorCobranca())
                    .aluno(cobranca.getAluno())
                    .plano(cobranca.getPlano())
                    .pago(false)
                    .mesCobranca(mesAtual.getDescricao())
                    .cancelado(false)
                    .numeroParcela(cobranca.getNumeroParcela())
                    .formaPagamento(cobranca.getFormaPagamento())
                    .build();
            cobranca.setNumeroParcela(cobranca.getNumeroParcela() + 1);
            numeroMes += 1;
            alunoCobrancaRepository.save(alunoCobranca);
        }
    }
}
