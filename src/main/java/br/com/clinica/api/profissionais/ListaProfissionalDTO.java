package br.com.clinica.api.profissionais;

public record ListaProfissionalDTO(Long id, String nome, String crm, Especialidade especialidade) {

    public ListaProfissionalDTO(Profissional profissional){
        this(profissional.getId(), profissional.getPessoa().getNome(), profissional.getCrm(), profissional.getEspecialidade());
    }

}
