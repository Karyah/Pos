package br.com.fiap.pet_tech.pet_tech;

import java.util.Collection;
import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service /* passa a inversão do controle da classe para o spring, spring responsavel 
pela instancia da classe toda vez qque a gnt faz injeção de dependencia*/
public class ProdutoService {
//lógica da aplicacao
	
	@Autowired
	private ProdutoRepository repo;
	
	public Collection<Produto> findAll(){
		var produtos = repo.findAll();
		return produtos;
	}
	
	public Optional<Produto> findbyId(UUID id){
		var produto = repo.findById(id);
		return produto;
	}
	
	public Produto save(Produto produto) {
		produto = repo.save(produto);
		return produto;
	}
	
	public Produto update(UUID id, Produto produto) {
		Produto buscaProduto = repo.getReferenceById(id);
		buscaProduto.setNome(produto.getNome());
		buscaProduto.setDescricao(produto.getDescricao());
		buscaProduto.setPreco(produto.getPreco());
		buscaProduto.setUrlDaImagem(produto.getUrlDaImagem());
		buscaProduto = repo.save(buscaProduto);
		return buscaProduto;
	}
	
	public void delete(UUID id) {
		repo.deleteById(id);
	}
}
