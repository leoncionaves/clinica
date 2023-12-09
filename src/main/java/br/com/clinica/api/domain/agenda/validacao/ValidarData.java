package br.com.clinica.api.domain.agenda.validacao;

import br.com.clinica.api.domain.agenda.DTOs.DadosAgendamentoDTO;
import br.com.clinica.api.infra.exception.ValidarExcecoes;
import org.springframework.stereotype.Component;

import java.time.Duration;
import java.time.LocalDate;
import java.time.ZoneId;

@Component
public class ValidarData implements VaidadorAgendamento{

    public void validar(DadosAgendamentoDTO dados){
        var dataAgendamento = dados.data();
        var dataAtual = LocalDate.now(ZoneId.of("America/Sao_Paulo"));
        if (dataAgendamento.isBefore(dataAtual)){
            throw new ValidarExcecoes("Data de agendamento deve ser igual ou maior que a data atual.");
        }
    }
}
