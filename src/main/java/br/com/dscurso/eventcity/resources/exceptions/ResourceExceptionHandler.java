package br.com.dscurso.eventcity.resources.exceptions;

import java.time.Instant;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import br.com.dscurso.eventcity.services.exceptions.ResourceEntityNotFoundException;



@ControllerAdvice
public class ResourceExceptionHandler {
  
	@ExceptionHandler(ResourceEntityNotFoundException.class)
	public ResponseEntity<StandardError> EntityNotFound(ResourceEntityNotFoundException erroEntity, HttpServletRequest request){
		StandardError error = new StandardError();
		HttpStatus status = HttpStatus.NOT_FOUND;
		error.setTimeStamp(Instant.now());
		error.setStatus(status.value());
		error.setError("Resource Not Found");
		error.setMessage(erroEntity.getMessage());
		error.setPath(request.getRequestURI());
		return ResponseEntity.status(status).body(error);
	}
}
