package br.com.clinica.api.domain.profissionais;

import br.com.clinica.api.domain.especialidade.Especialidade;
import br.com.clinica.api.domain.pessoa.Pessoa;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.ArrayList;

@Table(name = "profissionais")
@Entity(name = "Profissionais")
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
@SequenceGenerator(name = "seq_profissional", sequenceName = "seq_profissional", initialValue = 1, allocationSize = 1)
public class Profissional extends Pessoa {

//    @Id
//    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_profissional")
//    @SequenceGenerator(name = "seq_profissional", sequenceName = "seq_profissional", initialValue = 1, allocationSize = 1)
//    private Long idProfissional;

//    @Enumerated(EnumType.STRING)
@ManyToMany(fetch = FetchType.EAGER)
@JoinTable(name = "profissional_especialidade",
        joinColumns = @JoinColumn(name = "id_profissional"),
        inverseJoinColumns = @JoinColumn(name = "id_especialidade"))
    private ArrayList<Especialidade> especialidadeList;

    private String registroConselho;

    public Profissional(DadosCadastroProfissional dados) {
        super(dados.pessoa());
        //this.idEspecialidade = dados.idEspecialidade();
        this.registroConselho = dados.registroConselho();
    }

    public void atualizaCadastro (DadosAtualizacaoProfissional dados){
        if(dados.pessoa() != null) super.atualizarDados(dados.pessoa());
        if (dados.registroConselho() != null)   this.registroConselho = dados.registroConselho();
    }

}
