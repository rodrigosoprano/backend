package br.com.cpqd.controlepacientes.api.controller.dto;

import org.springframework.data.domain.Page;

import br.com.cpqd.controlepacientes.domain.model.Paciente;
import lombok.Getter;

@Getter
public class PacienteDTO {

	private Long id;
	private String nome;
	private String email;
	private String telefone;

	public PacienteDTO(Paciente paciente) {
		this.id = paciente.getId();
		this.nome = paciente.getNome();
		this.email = paciente.getEmail();
		this.telefone = paciente.getTelefone();
	}

	public static Page<PacienteDTO> converter(Page<Paciente> pacientes) {
		return pacientes.map(PacienteDTO::new);
	}

}
