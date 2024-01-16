package br.com.clinica.api.domain.profissionais;

import org.springframework.data.jpa.repository.JpaRepository;

public interface ProfissionalRepository extends JpaRepository <Profissional, Long> {
   // Page<Profissional> findAllByAtivoTrue(Pageable paginacao);
}
