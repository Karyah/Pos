package br.com.fiap.api.usuarios_pettech.controller.exception;

import java.time.Instant;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import jakarta.servlet.http.HttpServletRequest;

@ControllerAdvice
public class ControllerExceptionHandler {

	private StandardError err = new StandardError();

	@ExceptionHandler(ControllerNotFoundException.class)
	public ResponseEntity<StandardError> EntityNotFoundException(ControllerNotFoundException e,
			HttpServletRequest request) {

		HttpStatus status = HttpStatus.NOT_FOUND;
		err.setTimestamp(Instant.now());
		err.setStatus(status.value());
		err.setError("Entity not Found");
		err.setMessage(e.getMessage());
		err.setPath(request.getRequestURI());

		return ResponseEntity.status(status).body(this.err);
	}
}
