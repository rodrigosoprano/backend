package br.com.cpqd.controlepacientes.domain.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

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

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Date getDataNascimento() {
		return dataNascimento;
	}

	public void setDataNascimento(Date dataNascimento) {
		this.dataNascimento = dataNascimento;
	}

	public String getGenero() {
		return genero;
	}

	public void setGenero(String genero) {
		this.genero = genero;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public String getLogradouro() {
		return logradouro;
	}

	public void setLogradouro(String logradouro) {
		this.logradouro = logradouro;
	}

	public String getNumero() {
		return numero;
	}

	public void setNumero(String numero) {
		this.numero = numero;
	}

	public String getComplemento() {
		return complemento;
	}

	public void setComplemento(String complemento) {
		this.complemento = complemento;
	}

	public String getBairro() {
		return bairro;
	}

	public void setBairro(String bairro) {
		this.bairro = bairro;
	}

	public String getCidade() {
		return cidade;
	}

	public void setCidade(String cidade) {
		this.cidade = cidade;
	}
	
}
