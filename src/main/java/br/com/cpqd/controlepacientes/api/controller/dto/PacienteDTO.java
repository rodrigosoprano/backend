package br.com.cpqd.controlepacientes.api.controller.dto;

import java.util.Date;

import org.springframework.data.domain.Page;

import br.com.cpqd.controlepacientes.domain.model.Paciente;

public class PacienteDTO {

	private Long id;
	private String nome;
	private String cpf;
	private Date dataNascimento;

	public PacienteDTO(Paciente paciente) {
		this.id = paciente.getId();
		this.nome = paciente.getNome();
		this.cpf = paciente.getCpf();
		this.dataNascimento = paciente.getDataNascimento();
	}

	public Long getId() {
		return id;
	}

	public String getNome() {
		return nome;
	}

	public String getCpf() {
		return cpf;
	}

	public Date getDataNascimento() {
		return dataNascimento;
	}

	public static Page<PacienteDTO> converter(Page<Paciente> pacientes) {
		return pacientes.map(PacienteDTO::new);
	}

}
