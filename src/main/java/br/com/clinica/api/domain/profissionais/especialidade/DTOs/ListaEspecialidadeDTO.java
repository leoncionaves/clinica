package br.com.clinica.api.domain.profissionais.especialidade.DTOs;

import br.com.clinica.api.domain.profissionais.especialidade.Especialidade;

public record ListaEspecialidadeDTO(Long idEspecialidade, String especialidade) {

    public ListaEspecialidadeDTO(Especialidade especialidade){
        this(
                especialidade.getId(),
                especialidade.getEspecialidade()
        );
    }
}
