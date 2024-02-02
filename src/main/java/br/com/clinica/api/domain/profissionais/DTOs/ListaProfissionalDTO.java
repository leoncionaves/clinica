package br.com.clinica.api.domain.profissionais.DTOs;

import br.com.clinica.api.domain.profissionais.Profissional;
import br.com.clinica.api.domain.profissionais.especialidade.Especialidade;

import java.util.List;

public record ListaProfissionalDTO(Long id, String nome, String registroConselho, List <Especialidade> especialidade) {

    public ListaProfissionalDTO(Profissional profissional){
        this(profissional.getId(),
             profissional.getNome(),
             profissional.getRegistroConselho(),
             profissional.getEspecialidadeList());
    }

}
