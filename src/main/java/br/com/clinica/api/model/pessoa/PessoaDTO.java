package br.com.clinica.api.model.pessoa;

import jakarta.validation.Valid;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;

import java.util.Date;

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

        //Boolean ativo,

        Date dataCadastro
        ) {
}
