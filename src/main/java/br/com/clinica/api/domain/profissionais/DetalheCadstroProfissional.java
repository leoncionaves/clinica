package br.com.clinica.api.domain.profissionais;

import br.com.clinica.api.domain.especialidade.Especialidade;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.List;

@JsonIgnoreProperties({"especialidadeList"})
public record DetalheCadstroProfissional(Long id, String pessoa, List<Especialidade> especialidade, String crm, Boolean ativo) {

    public DetalheCadstroProfissional(Profissional profissional) {
        this(profissional.getId(),
                profissional.getNome(),
                profissional.getEspecialidadeList(),
                profissional.getRegistroConselho(),
                profissional.getAtivo());
    }
}
