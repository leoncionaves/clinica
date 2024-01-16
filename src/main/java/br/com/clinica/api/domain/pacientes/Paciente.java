package br.com.clinica.api.domain.pacientes;

import br.com.clinica.api.domain.pessoa.Pessoa;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Table(name = "pacientes")
@Entity(name = "Pacientes")
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Paciente extends Pessoa {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_paciente")
    @SequenceGenerator(name = "seq_paciente", sequenceName = "seq_paciente", initialValue = 1, allocationSize = 1)
    private Long id;

    private LocalDate dataNascimento;
    private String sexo;

    public Paciente(DadosCadastroPaciente dados) {
        super(dados.pessoa());
        this.dataNascimento = dados.dataNascimento();
        this.sexo = dados.sexo();
    }
}
