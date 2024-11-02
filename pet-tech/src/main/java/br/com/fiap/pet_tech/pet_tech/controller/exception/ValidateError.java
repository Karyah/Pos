package br.com.fiap.pet_tech.pet_tech.controller.exception;

import java.util.ArrayList;
import java.util.List;

public class ValidateError extends StandardError{
	List<ValidateMessage> mensagens = new ArrayList<>();

	public List<ValidateMessage> getMensagens() {
		return mensagens;
	}

	public void addMensagens(String campo, String mensagem) {
		mensagens.add(new ValidateMessage(campo, mensagem));
	}
	
	
}
