package br.com.clinica.api.domain.pessoa;

import jakarta.persistence.Embedded;
import jakarta.persistence.Inheritance;
import jakarta.persistence.InheritanceType;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

//@Embeddable
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
public class Pessoa {

    private String nome;

    private String telefone;

    private String email;

    @Embedded
    private Endereco endereco;

    private Boolean ativo;

    private LocalDate dataCadastro;

    public Pessoa(PessoaDTO dados) {
        this.nome = dados.nome();
        this.email = dados.email();
        this.telefone = dados.telefone();
        this.ativo = dados.ativo();
        this.dataCadastro = dados.dataCadastro();
        this.endereco = new Endereco(dados.endereco());
    }

    public void atualizarDados(PessoaDTO dados) {
        if (dados.nome() != null) this.nome = dados.nome();
        if (dados.email() != null) this.email = dados.email();
        if (dados.telefone() != null) this.telefone = dados.telefone();
        if (dados.ativo() != null) this.ativo = dados.ativo();
        if (dados.dataCadastro() != null) this.dataCadastro = dados.dataCadastro();
        if (dados.endereco() != null ) this.endereco.atualizaEndereco(dados.endereco());
    }
}
