package br.com.organicxpto.pedidos;

import java.math.BigDecimal;

public class RemoverEstoqueRequest {
	// Tem que espelhar o objeto que é recebido naquela request, respeitando os tipos e nomes dos atributos
	// Vamos fazer esse objeto baseado no "ProdutoRequest"
	private Long idProduto;
	
	private BigDecimal quantidade;

	public RemoverEstoqueRequest() {
		super();
	}

	public RemoverEstoqueRequest(Long idProduto, BigDecimal quantidade) {
		super();
		this.idProduto = idProduto;
		this.quantidade = quantidade;
	}

	public Long getIdProduto() {
		return idProduto;
	}

	public BigDecimal getQuantidade() {
		return quantidade;
	}
	
}
	
