package br.com.clinica.api.model.pessoa;

import jakarta.persistence.Embeddable;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Embeddable
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Endereco {

    private String logradouro;
    private String numero;
    private String complemento;
    private String bairro;
    private String cidade;

    @Enumerated(EnumType.STRING)
    private UnidadeFederativa uf;
    private String cep;

    public Endereco(DadosEndereco dados) {
        this.logradouro = dados.logradouro();
        this.numero = dados.numero();
        this.complemento = dados.complemento();
        this.bairro = dados.bairro();
        this.cidade = dados.cidade();
        this.uf = dados.uf();
        this.cep = dados.cep();
    }

    public void atualizaEndereco(DadosEndereco dados) {
        if (dados.logradouro() != null) this.logradouro = dados.logradouro();
        if (dados.numero() != null) this.numero = dados.numero();
        if (dados.complemento() != null) this.complemento = dados.complemento();
        if (dados.bairro() != null) this.bairro = dados.bairro();
        if (dados.cidade() != null) this.cidade = dados.cidade();
        if (dados.uf() != null) this.uf = dados.uf();
        if (dados.cep() != null) this.cep = dados.cep();
    }
}
