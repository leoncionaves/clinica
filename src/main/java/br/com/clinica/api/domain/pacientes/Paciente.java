package br.com.clinica.api.domain.pacientes;

import br.com.clinica.api.domain.pessoa.Pessoa;
import jakarta.persistence.Entity;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
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
@SequenceGenerator(name = "seq_paciente", sequenceName = "seq_paciente", initialValue = 1, allocationSize = 1)
public class Paciente extends Pessoa {

//    @Id
//    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_paciente")
//    @SequenceGenerator(name = "seq_paciente", sequenceName = "seq_paciente", initialValue = 1, allocationSize = 1)
//    private Long idPaciente;

    private LocalDate dataNascimento;
    private String sexo;

    public Paciente(DadosCadastroPaciente dados) {
        super(dados.pessoa());
        this.dataNascimento = dados.dataNascimento();
        this.sexo = dados.sexo();
    }
}
