package br.com.clinica.api.model.pessoa;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record DadosEndereco(
        @NotBlank
        String logradouro,

        String numero,

        String complemento,

        String bairro,
        @NotBlank
        String cidade,

        @NotNull
        UnidadeFederativa uf,
        @NotBlank
        String cep) {
}
