package br.com.fiap.pet_tech.pet_tech.controller.exception;

public class ValidateMessage {

	private String campo;
	private String mensagem;
	
	public ValidateMessage() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public ValidateMessage(String campo, String mensagem) {
		super();
		this.campo = campo;
		this.mensagem = mensagem;
	}

	public String getCampo() {
		return campo;
	}

	public void setCampo(String campo) {
		this.campo = campo;
	}

	public String getMensagem() {
		return mensagem;
	}

	public void setMensagem(String mensagem) {
		this.mensagem = mensagem;
	}
	
	
}
