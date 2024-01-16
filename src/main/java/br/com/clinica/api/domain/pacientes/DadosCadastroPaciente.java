package br.com.clinica.api.domain.pacientes;

import br.com.clinica.api.domain.pessoa.PessoaDTO;

import java.time.LocalDate;

public record DadosCadastroPaciente(
        PessoaDTO pessoa,
        LocalDate dataNascimento,
        String sexo) {}
