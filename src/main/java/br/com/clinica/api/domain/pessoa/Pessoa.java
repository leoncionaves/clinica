package br.com.clinica.api.domain.pessoa;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.time.LocalDate;

@Entity
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public abstract class Pessoa implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_pessoa")
    @SequenceGenerator(name = "seq_pessoa", sequenceName = "seq_pessoa", initialValue = 1, allocationSize = 1)
    private Long id;

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
