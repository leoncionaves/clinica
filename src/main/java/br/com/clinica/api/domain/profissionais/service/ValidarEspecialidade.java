package br.com.clinica.api.domain.profissionais.service;

import br.com.clinica.api.domain.especialidade.EspecialidadeRepository;
import br.com.clinica.api.domain.profissionais.DTOs.DadosCadastroProfissional;

import java.util.List;

public class ValidarEspecialidade implements ValidarDadosProfissional {

    private EspecialidadeRepository repository;
    @Override
    public void validar(DadosCadastroProfissional dados) {
        List<Long> idEspecialidade = dados.idEspecialidade();
       // idEspecialidade.forEach();
    }
}
