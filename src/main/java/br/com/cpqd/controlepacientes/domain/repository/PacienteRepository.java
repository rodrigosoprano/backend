package br.com.cpqd.controlepacientes.domain.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import br.com.cpqd.controlepacientes.domain.model.Paciente;

public interface PacienteRepository extends JpaRepository<Paciente, Long> {

	Page<Paciente> findByNome(String nome, Pageable paginacao);
	
	Paciente findByCpf(String cpf);
	
	Paciente findByEmail(String email);

}
