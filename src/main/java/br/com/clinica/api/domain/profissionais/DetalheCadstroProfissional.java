package br.com.clinica.api.domain.profissionais;

import br.com.clinica.api.domain.especialidade.Especialidade;

import java.util.ArrayList;

public record DetalheCadstroProfissional(Long id, String pessoa, ArrayList<Especialidade> especialidade, String crm, Boolean ativo) {

    public DetalheCadstroProfissional(Profissional profissional) {
        this(profissional.getId(),
                profissional.getNome(),
                profissional.getEspecialidadeList(),
                profissional.getRegistroConselho(),
                profissional.getAtivo());
    }
}
