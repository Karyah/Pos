package br.com.fiap.mspedido.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import br.com.fiap.mspedido.model.Pedido;

public interface PedidoRepository extends MongoRepository<Pedido, String>{

}
