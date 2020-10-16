package br.com.cpqd.controlepacientes.domain.service;

import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import br.com.cpqd.controlepacientes.api.controller.dto.PacienteDTO;
import br.com.cpqd.controlepacientes.domain.exception.ServiceException;
import br.com.cpqd.controlepacientes.domain.model.Paciente;
import br.com.cpqd.controlepacientes.domain.repository.PacienteRepository;

@Service
public class PacienteService {

	@Autowired
	private PacienteRepository pacienteRepository;

	public Page<PacienteDTO> list(String nomePaciente, Pageable paginacao) {

		if (nomePaciente == null) {
			Page<Paciente> pacientes = pacienteRepository.findAll(paginacao);
			return PacienteDTO.converter(pacientes);
		} else {
			Page<Paciente> pacientes = pacienteRepository.findByNome(nomePaciente, paginacao);
			return PacienteDTO.converter(pacientes);
		}
	}

	public ResponseEntity<Paciente> search(Long pacienteId) {
		Optional<Paciente> paciente = pacienteRepository.findById(pacienteId);

		if (paciente.isPresent())
			return ResponseEntity.ok(paciente.get());

		return ResponseEntity.notFound().build();
	}

	public PacienteDTO save(Paciente paciente) {

		Paciente pacienteExistsByCpf = pacienteRepository.findByCpf(paciente.getCpf());
		Paciente pacienteExistsByEmail = pacienteRepository.findByEmail(paciente.getEmail());

		if (pacienteExistsByCpf != null && !pacienteExistsByCpf.equals(paciente))
			throw new ServiceException("Já existe um paciente cadastrado com esse CPF");

		if (pacienteExistsByEmail != null && !pacienteExistsByEmail.equals(paciente))
			throw new ServiceException("Já existe um paciente cadastrado com esse EMAIL");

		return new PacienteDTO(pacienteRepository.save(paciente));
	}

	public ResponseEntity<PacienteDTO> update(@Valid Paciente paciente, Long pacienteId) {

		if (!pacienteRepository.existsById(pacienteId)) {
			return ResponseEntity.notFound().build();
		}

		paciente.setId(pacienteId);
		save(paciente);
		return ResponseEntity.ok(new PacienteDTO(paciente));
	}

	public ResponseEntity<?> delete(Long pacienteId) {
		if (!pacienteRepository.existsById(pacienteId)) {
			return ResponseEntity.notFound().build();
		}

		pacienteRepository.deleteById(pacienteId);
		return ResponseEntity.ok().build();
	}

}
