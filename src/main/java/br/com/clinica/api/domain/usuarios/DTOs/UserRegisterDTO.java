package br.com.clinica.api.domain.usuarios.DTOs;

import br.com.clinica.api.domain.usuarios.perfil.Roles;

public record UserRegisterDTO(String usuario, String senha, Roles role){
}
