package br.com.fiap.mspedido.model;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ItemPedido {
	
	private Integer idProduto;
	private int quantidade;
}
