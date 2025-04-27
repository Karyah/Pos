package br.com.organicxpto.pedidos;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PedidoController {

	private final PedidoService pedidoService;
	
	public PedidoController(PedidoService pedidoService) {
		this.pedidoService = pedidoService;
	}
	
	@GetMapping("get-all")
	public ResponseEntity<List<Pedido>> getAllIdPedidos(){
		return ResponseEntity.ok(this.pedidoService.getAll());
	}
}
