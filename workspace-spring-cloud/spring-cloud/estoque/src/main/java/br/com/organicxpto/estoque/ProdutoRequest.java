package br.com.organicxpto.estoque;

import java.math.BigDecimal;

// Informações que precisamos receber da request apenas.
public class ProdutoRequest {

	private Long idProduto;

	private BigDecimal quantidade;

	public ProdutoRequest() {
		super();
	}

	public Long getIdProduto() {
		return idProduto;
	}

	public BigDecimal getQuantidade() {
		return quantidade;
	}
}
