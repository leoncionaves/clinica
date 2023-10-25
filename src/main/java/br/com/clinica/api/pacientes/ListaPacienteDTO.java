package br.com.clinica.api.pacientes;

public record ListaPacienteDTO(Long id, String nome, String telefone) {

    public ListaPacienteDTO(Paciente paciente){
        this(paciente.getId(), paciente.getPessoa().getNome(), paciente.getPessoa().getTelefone());
    }
}
