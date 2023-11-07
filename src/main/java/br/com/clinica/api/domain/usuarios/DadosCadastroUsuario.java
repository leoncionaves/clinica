package br.com.clinica.api.domain.usuarios;

import br.com.clinica.api.domain.pessoa.PessoaDTO;

public record DadosCadastroUsuario(PessoaDTO pessoa,
                                   String usuario,
                                   String senha,
                                   Roles role) {
}
