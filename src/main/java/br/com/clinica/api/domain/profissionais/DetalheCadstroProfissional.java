package br.com.clinica.api.domain.profissionais;

public record DetalheCadstroProfissional(Long id, String pessoa, Especialidade especialidade, String crm, Boolean ativo) {

    public DetalheCadstroProfissional(Profissional profissional) {
        this(profissional.getId(),
                profissional.getNome(),
                profissional.getEspecialidade(),
                profissional.getCrm(),
                profissional.getAtivo());
    }
}
