package br.com.organicxpto.estoque;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.stereotype.Service;

@Service
public class ProdutoService {

	private List<Produto> fakeDd = List.of(
			new Produto(1L, "Tomates", BigDecimal.valueOf(1000000)),
			new Produto(2L, "Abacaxi", BigDecimal.TEN)
			);
	
	public List<Produto> getAll() { return this.fakeDd; }
	
	public void removerEstoque(Long idProduto, BigDecimal quantidade ) {
		this.fakeDd.stream().filter(x -> x.getId().equals(idProduto))
							.findFirst()
							.orElseThrow().removerEstoque(quantidade);
		
	}
}
