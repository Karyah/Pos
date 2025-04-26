package br.com.fiap.mspedido.service;

import java.io.IOException;
import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import br.com.fiap.mspedido.model.ItemPedido;
import br.com.fiap.mspedido.model.Pedido;
import br.com.fiap.mspedido.repository.PedidoRepository;

@Service
public class PedidoService {

	@Autowired
	private PedidoRepository pedidoRepository;
	
	@Autowired
	private RestTemplate restTemplate; 
	
	@Autowired
	private ObjectMapper objectMapper;
	
	public Pedido criarPedido(Pedido pedido) {
		
		boolean produtoDisponivel = verificarDisponibilidadeProduto(pedido.getItensPedido());
		
		if (!produtoDisponivel) {
			throw new NoSuchElementException("Um ou mais produtos não estão disponíveis");
		}
		
		double valorTotal = calcularValorTotal(pedido.getItensPedido() );
		pedido.setValorTotal(valorTotal);
		
		atualizarEstoqueProdutos(pedido.getItensPedido());
		
		return pedidoRepository.save(pedido);
	}
	
	public List<Pedido> listarPedidos(){
		return pedidoRepository.findAll();
	}

	private void atualizarEstoqueProdutos(List<ItemPedido> itensPedido) {
		for (ItemPedido item : itensPedido) {
			Integer idProduto = item.getIdProduto();
			int quantidade = item.getQuantidade();
			
			restTemplate.put(
					"http://localhost:8080/api/produtos/atualizar/estoque/{produtoId}/{quantidade}", 
					null,
					idProduto, 
					quantidade
			);
		}
	}

	private double calcularValorTotal(List<ItemPedido> itensPedido) {
		double valorTotal = 0.0;
		
		for (ItemPedido item : itensPedido) {
			Integer idProduto = item.getIdProduto();
			int quantidade = item.getQuantidade();
			
			ResponseEntity<String> response = restTemplate.getForEntity(
					"http://localhost:8080/api/produtos/{produtoId}", 
					String.class,
					idProduto);
			
			if (response.getStatusCode() == HttpStatus.OK) {
				try {
					JsonNode produtoJson = objectMapper.readTree(response.getBody());
					double preco = produtoJson.get("preco").asDouble();
					
					valorTotal += preco * quantidade;
					
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
		
		return valorTotal;
	}

	private boolean verificarDisponibilidadeProduto(List<ItemPedido> itensPedido) {
		for (ItemPedido item : itensPedido) {
			Integer idProduto = item.getIdProduto();
			int quantidade = item.getQuantidade();
			
				ResponseEntity<String> response = restTemplate.getForEntity(
						"http://localhost:8080/api/produtos/{produtoId}", 
						String.class, 
						idProduto);
				
				if (response.getStatusCode() == HttpStatus.NOT_FOUND) {
					throw new NoSuchElementException("Produto não encontrado.");
				}
				
				try {
					JsonNode produtoJson = objectMapper.readTree(response.getBody());
					int quantidadeEstoque = produtoJson.get("quantidade_estoque").asInt();
					
					if (quantidadeEstoque < quantidade) {
						return false; 
					}
				} catch ( IOException e) {
					e.printStackTrace();
				}
		}
		return true;
	}
}
