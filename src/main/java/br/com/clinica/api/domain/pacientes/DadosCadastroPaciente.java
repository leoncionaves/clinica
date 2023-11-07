package br.com.clinica.api.domain.pacientes;

import br.com.clinica.api.domain.pessoa.PessoaDTO;

import java.util.Date;

public record DadosCadastroPaciente(PessoaDTO pessoa, Date dataNascimento, String sexo, Boolean ativo) {}
