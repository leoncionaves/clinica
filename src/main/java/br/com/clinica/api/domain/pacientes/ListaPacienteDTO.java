package br.com.clinica.api.domain.pacientes;

public record ListaPacienteDTO(Long id, String nome, String telefone) {

    public ListaPacienteDTO(Paciente paciente){
        this(paciente.getId(), paciente.getNome(), paciente.getTelefone());
    }
}
