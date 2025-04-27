package br.com.organicxpto.pedidos;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient(value = "estoque", url = "http://localhost:8081/api")
public interface EstoquePedidoProducer {
	
	
	// Tem que ser método compatível com o que criamos no estoque. O value tem que ser o nome 
	// da endpoint criada no estoque.
	@PostMapping(value = "/remover-estoque")
	void removerEstoque(@RequestBody RemoverEstoqueRequest removerEstoqueRequest);
}
