package br.com.fiap.mspedido.model;

import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import lombok.Data;

@Data
@Document("pedido")
public class Pedido {

	@Id
	private String id;
	
	private String nomeCliente;
	
	private List<ItemPedido> itensPedido;
	
	private double valorTotal;
}
