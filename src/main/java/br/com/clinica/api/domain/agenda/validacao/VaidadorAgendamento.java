package br.com.clinica.api.domain.agenda.validacao;

import br.com.clinica.api.domain.agenda.DTOs.DadosAgendamentoDTO;

public interface VaidadorAgendamento {

    void validar(DadosAgendamentoDTO dados);
}
