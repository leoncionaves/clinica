package br.com.clinica.api.domain.usuarios.DTOs;

import br.com.clinica.api.domain.pessoa.PessoaDTO;
import br.com.clinica.api.domain.usuarios.perfil.Roles;

public record DadosCadastroUsuario(PessoaDTO pessoa,
                                   String usuario,
                                   String senha,
                                   Roles role) {
}
