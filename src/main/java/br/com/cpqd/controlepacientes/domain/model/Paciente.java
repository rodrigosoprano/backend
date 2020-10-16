package br.com.cpqd.controlepacientes.domain.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class Paciente {

//	• Nome - Texto (100);
//	• CPF – alfanumérico(11);
//	• E-mail – alfanumérico(100);
//	• Data_Nascimento – date;
//	• Gênero – Texto(15);
//	• Telefone – alfanumérico(15);
//	• Logradouro – alfanumérico(180);
//	• Número – alfanumérico (10);
//	• Complemento – alfanumérico(100);
//	• Bairro – alfanumérico(100);
//	• Cidade – alfanumérico(100);

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@NotBlank
	@Size(max = 100)
	private String nome;
	
	@NotBlank
	@Size(max = 11)
	private String cpf;
	
	@Email
	private String email;
	
	private Date dataNascimento;
	
	@NotBlank
	@Size(max = 15)
	private String genero;
	
	@NotBlank
	@Size(max = 15)
	private String telefone;
	
	@NotBlank
	@Size(max = 180)
	private String logradouro;
	
	@NotBlank
	@Size(max = 10)
	private String numero;
	
	@NotBlank
	@Size(max = 100)
	private String complemento;
	
	@NotBlank
	@Size(max = 100)
	private String bairro;
	
	@NotBlank
	@Size(max = 100)
	private String cidade;

}
