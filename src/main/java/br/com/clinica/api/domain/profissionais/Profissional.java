package br.com.clinica.api.domain.profissionais;

import br.com.clinica.api.domain.pessoa.Pessoa;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Table(name = "profissionais")
@Entity(name = "Profissionais")
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Profissional {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_profissional")
    @SequenceGenerator(name = "seq_profissional", sequenceName = "seq_profissional", initialValue = 1, allocationSize = 1)
    private Long id;

    @Embedded
    private Pessoa pessoa;

    @Enumerated(EnumType.STRING)
    private Especialidade especialidade;

    private String crm;

    private Boolean ativo;

    public Profissional(DadosCadastroProfissional dados) {
        this.pessoa = new Pessoa(dados.pessoa());
        this.especialidade = dados.especialidade();
        this.crm = dados.crm();
        this.ativo = dados.ativo();
    }

    public void atualizaCadastro (DadosAtualizacaoProfissional dados){
        if(dados.pessoa() != null) this.pessoa.atualizarDados(dados.pessoa());
        if (dados.crm() != null)   this.crm = dados.crm();
        if (dados.ativo() != null) this.ativo = dados.ativo();
    }
}
