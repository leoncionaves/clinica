package br.com.clinica.api.domain.profissionais.service;

import br.com.clinica.api.domain.especialidade.Especialidade;
import br.com.clinica.api.domain.especialidade.EspecialidadeRepository;
import br.com.clinica.api.domain.profissionais.DTOs.DadosCadastroProfissional;
import br.com.clinica.api.domain.profissionais.Profissional;
import br.com.clinica.api.domain.profissionais.ProfissionalRepository;
import br.com.clinica.api.infra.exception.ValidarExcecoes;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CadastroProfissionalService {

    @Autowired
    private ProfissionalRepository profissionalRepository;

    @Autowired
    private EspecialidadeRepository especialidadeRepository;


    public Profissional cadastrar (DadosCadastroProfissional dados){
    //DetalheCadstroProfissional cadastrar (DadosCadastroProfissional dados){
        /*
         * Espaço para validações/regras de negócio
         *

        validador.forEach(v-> v.validar(dados));

        var profissional = profissionalRepository.getReferenceById(dados.idProfissional());
        var paciente = pacienteRepository.getReferenceById(dados.idPaciente());
        var agendamento = new Agendamento(null, profissional, paciente, dados.data(), dados.hora(),dados.confirmada(), dados.observacao());
        agendamentoRepository.save(agendamento);
        return new AgendaDetalheDTO(agendamento);*/

        //List<Long> idEspecialidade = dados.idEspecialidade();


            List<Especialidade> listEspecialidade= new ArrayList<>();

            for (Long id : dados.idEspecialidade()) {
                if (especialidadeRepository.existsById(id)) {
                    var especialidade = especialidadeRepository.findById(id).orElse(null);
                    listEspecialidade.add(especialidade);
                } else {
                    throw new ValidarExcecoes("ID " + id + " NÃO existe na tabela especialidade.");
                }
            }

            return profissionalRepository.save(new Profissional(dados, listEspecialidade));
    }

}
