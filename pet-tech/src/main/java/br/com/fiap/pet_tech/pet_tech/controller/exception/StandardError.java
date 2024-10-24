package br.com.fiap.pet_tech.pet_tech.controller.exception;

import java.time.Instant;

public class StandardError {
	/*retornar um erro p cliente de forma mais amigavel*/
	private Instant timestamp;
	
	private Integer status;
	
	private String error;
	
	private String message;
	
	private String path;

	public StandardError() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Instant getTimestamp() {
		return timestamp;
	}

	public void setTimestamp(Instant timestamp) {
		this.timestamp = timestamp;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public String getError() {
		return error;
	}

	public void setError(String error) {
		this.error = error;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public String getPath() {
		return path;
	}

	public void setPath(String path) {
		this.path = path;
	}
	
	
}
