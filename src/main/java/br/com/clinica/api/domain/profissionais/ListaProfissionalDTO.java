package br.com.clinica.api.domain.profissionais;

public record ListaProfissionalDTO(Long id, String nome, String crm, Especialidade especialidade) {

    public ListaProfissionalDTO(Profissional profissional){
        this(profissional.getId(), profissional.getNome(), profissional.getCrm(), profissional.getEspecialidade());
    }

}
