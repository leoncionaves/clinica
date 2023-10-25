package br.com.clinica.api.pacientes;

import br.com.clinica.api.model.pessoa.PessoaDTO;

import java.util.Date;

public record DadosCadastroPaciente(PessoaDTO pessoa, Date dataNascimento, String sexo, Boolean ativo) {}
