package br.com.clinica.api.domain.especialidade;

import br.com.clinica.api.domain.profissionais.Profissional;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

@Table(name = "especialidades")
@Entity(name = "Especialidades")
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Especialidade {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_especialidade")
    @SequenceGenerator(name = "seq_especialidade", sequenceName = "seq_especialidade", initialValue = 1, allocationSize = 1)
    private Long id;
    private String especialidade;

    @ManyToMany(mappedBy = "especialidadeList", fetch = FetchType.EAGER)
    @JsonIgnore
    private List<Profissional> profissionalList;

    public Especialidade(DadosCadastroEspecialidade dados) {
        this.id = dados.idEspecialidade();
        this.especialidade = dados.especialidade();
    }

    @Transactional
    public void adicionarProfissional(Profissional profissional) {
        // Crie uma entrada na tabela de junção para associar esta especialidade ao profissional
        this.getProfissionalList().add(profissional);
        profissional.getEspecialidadeList().add(this);
    }
}
