package br.com.clinica.api.domain.profissionais;

import br.com.clinica.api.domain.pessoa.Pessoa;
import jakarta.persistence.*;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Table(name = "profissionais")
@Entity(name = "Profissionais")
@Getter
@NoArgsConstructor
//@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Profissional extends Pessoa implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_profissional")
    @SequenceGenerator(name = "seq_profissional", sequenceName = "seq_profissional", initialValue = 1, allocationSize = 1)
    private Long id;

    @Enumerated(EnumType.STRING)
    private Especialidade especialidade;

    private String crm;

    public Profissional(DadosCadastroProfissional dados) {
        super(dados.pessoa());
        this.especialidade = dados.especialidade();
        this.crm = dados.crm();
    }

    public void atualizaCadastro (DadosAtualizacaoProfissional dados){
        if(dados.pessoa() != null) super.atualizarDados(dados.pessoa());
        if (dados.crm() != null)   this.crm = dados.crm();
        //if (dados.ativo() != null) this.ativo = dados.ativo();
    }

}
