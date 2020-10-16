package br.com.cpqd.controlepacientes.api.controller;

import javax.transaction.Transactional;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import br.com.cpqd.controlepacientes.api.controller.dto.PacienteDTO;
import br.com.cpqd.controlepacientes.domain.model.Paciente;
import br.com.cpqd.controlepacientes.domain.service.PacienteService;

@RestController
@RequestMapping("/pacientes")
public class PacienteController {

	@Autowired
	private PacienteService pacienteService;

	@GetMapping
	public Page<PacienteDTO> list(@RequestParam(required = false) String nomePaciente,
			@PageableDefault(sort = "id", direction = Direction.ASC, page = 0, size = 10) Pageable paginacao) {
		return pacienteService.list(nomePaciente, paginacao);
	}

	@GetMapping("/{pacienteId}")
	public ResponseEntity<Paciente> search(@PathVariable Long pacienteId) {
		return pacienteService.search(pacienteId);
	}

	@PostMapping
	@Transactional
	@ResponseStatus(HttpStatus.CREATED)
	public PacienteDTO save(@RequestBody @Valid Paciente paciente) {
		return pacienteService.save(paciente);
	}

	@PutMapping("/{pacienteId}")
	@Transactional
	public ResponseEntity<PacienteDTO> update(@PathVariable Long pacienteId, @RequestBody @Valid Paciente paciente) {
		return pacienteService.update(paciente, pacienteId);
	}

	@DeleteMapping("/{pacienteId}")
	@Transactional
	public ResponseEntity<?> delete(@PathVariable Long pacienteId) {
		return pacienteService.delete(pacienteId);
	}

}
