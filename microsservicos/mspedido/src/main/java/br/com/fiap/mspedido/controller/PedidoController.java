package br.com.fiap.mspedido.controller;

import java.util.List;
import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.fiap.mspedido.model.Pedido;
import br.com.fiap.mspedido.service.PedidoService;

@RestController
@RequestMapping("/api/pedidos")
public class PedidoController {
	
	@Autowired
	private PedidoService pedidoService;
	
	@PostMapping
	public ResponseEntity<?> criarPedido(@RequestBody Pedido pedido) {
		try {
			Pedido novoPedido = pedidoService.criarPedido(pedido);
			return new ResponseEntity<>(novoPedido, HttpStatus.CREATED);
		} catch (NoSuchElementException e) {
			return new ResponseEntity<>("Um ou mais produtos não estão disponíveis", HttpStatus.BAD_REQUEST);
		}
		
	}
	
	@GetMapping
	public List<Pedido> listarPedidos(){
		return pedidoService.listarPedidos();
	}
}
