package br.com.cpqd.controlepacientes.api.exceptionhandler;

import lombok.Getter;

@Getter
public class FormException {

	private String field;
	private String error;

	public FormException(String field, String error) {
		this.field = field;
		this.error = error;
	}

}
