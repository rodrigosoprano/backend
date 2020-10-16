package br.com.cpqd.controlepacientes.api.exceptionhandler;

import lombok.Getter;

@Getter
public class Exception {

	private String message;

	public Exception(String message) {
		this.message = message;
	}

}
