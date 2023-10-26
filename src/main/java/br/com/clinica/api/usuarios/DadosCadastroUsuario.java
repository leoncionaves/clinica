package br.com.clinica.api.usuarios;

import br.com.clinica.api.model.pessoa.PessoaDTO;

public record DadosCadastroUsuario(PessoaDTO pessoa,
                                   String usuario,
                                   String senha,
                                   Roles role) {
}
