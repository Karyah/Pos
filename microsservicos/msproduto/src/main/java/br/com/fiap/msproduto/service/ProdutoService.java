package br.com.fiap.msproduto.service;

import java.util.List;
import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import br.com.fiap.msproduto.model.Produto;
import br.com.fiap.msproduto.repository.ProdutoRepository;

@Service
public class ProdutoService {

	@Autowired
	private ProdutoRepository produtoRepository;
	
	public List<Produto> listarProduto(){
		return produtoRepository.findAll();
	}
	
	public Produto cadastrarProduto(Produto produto) {
		return produtoRepository.save(produto);
	}
	
	public ResponseEntity<?> consultarProduto(Integer produtoId) {
		Produto produto = produtoRepository.findById(produtoId).orElse(null);
		
		if (produto!=null) {
			return ResponseEntity.ok(produto);
		}else {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Produto não encontrado");
		}
		
	}
	
	public Produto atualizarProduto(Integer produtoId, Produto produto) {
		Produto produtoExistente = produtoRepository.findById(produtoId).orElse(null);
		
		if (produtoExistente!= null) {
			produtoExistente.setNome(produto.getNome());
			produtoExistente.setDescricao(produto.getDescricao());
			produtoExistente.setQuantidade_estoque(produto.getQuantidade_estoque());
			produtoExistente.setPreco(produto.getPreco());
			return produtoRepository.save(produtoExistente);
		}else {
			throw new NoSuchElementException("Produto não existente");
		}	
	}
	
	public void excluirProduto(Integer produtoId) {
		Produto produtoExistente = produtoRepository.findById(produtoId).orElse(null);
		if (produtoExistente!=null) {
			produtoRepository.delete(produtoExistente);
		}else {
			throw new NoSuchElementException("Produto não existente");
		}
	}
	
	public Produto atualizarEstoque(Integer produtoId, int quantidade) {
		Produto produto = produtoRepository.getById(produtoId);
		
		if (produto!= null) {
			produto.setQuantidade_estoque(produto.getQuantidade_estoque() - quantidade);
			return produtoRepository.save(produto);
		}else {
			return null;
		}
			
	}
}
