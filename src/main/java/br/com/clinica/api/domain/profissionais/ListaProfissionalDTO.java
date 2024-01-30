package br.com.clinica.api.domain.profissionais;

import br.com.clinica.api.domain.especialidade.Especialidade;

import java.util.ArrayList;

public record ListaProfissionalDTO(Long id, String nome, String registroConselho, ArrayList<Especialidade> especialidade) {

    public ListaProfissionalDTO(Profissional profissional){
        this(profissional.getId(),
             profissional.getNome(),
             profissional.getRegistroConselho(),
             profissional.getEspecialidadeList());
    }

}
