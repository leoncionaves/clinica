package br.com.clinica.api.model.pessoa;

import jakarta.persistence.Embeddable;
import jakarta.persistence.Embedded;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.Date;

@Embeddable
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Pessoa {

    private String nome;

    private String telefone;

    private String email;

    @Embedded
    private Endereco endereco;

   // private Boolean ativo;

    private Date dataCadastro;

    public Pessoa(PessoaDTO dados) {
        this.nome = dados.nome();
        this.email = dados.email();
        this.telefone = dados.telefone();
        //this.ativo = dados.ativo();
        this.dataCadastro = dados.dataCadastro();
        this.endereco = new Endereco(dados.endereco());
    }
}
