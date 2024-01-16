package br.com.clinica.api.domain.pessoa;

import jakarta.validation.Valid;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;

import java.time.LocalDate;

public record PessoaDTO(
        @NotBlank
        String nome,
        @Pattern(regexp = "\\d{11}")
        String telefone,
        @Email
        String email,
        @NotBlank
        @Valid
        DadosEndereco endereco,

        Boolean ativo,

        LocalDate dataCadastro
        ) {
}
