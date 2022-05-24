package br.com.dscurso.eventcity.services.exceptions;

public class ResourceEntityNotFoundException extends RuntimeException{

	private static final long serialVersionUID = 1L;

	public ResourceEntityNotFoundException(String mensagem){
		super(mensagem);
	}

}
