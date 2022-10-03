package br.com.seguranca.services;

import java.util.ArrayList;
import java.util.List;

import br.com.seguranca.dto.ProdutoDTO;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.seguranca.model.Produto;
import br.com.seguranca.repositories.ProdutoRepositorio;

@Service
public class ProdutoServico {

	@Autowired
	private ProdutoRepositorio produtoRepository;



	public Produto inserirProduto(ProdutoDTO produtoDTO) {
		Produto produto = new Produto();
		BeanUtils.copyProperties(produtoDTO, produto);
		return produtoRepository.save(produto);
	}
	
	
	public List<ProdutoDTO> listarProdutos (){
		List <Produto> produtos = new ArrayList<>();
		List<ProdutoDTO> produtoDTOS = new ArrayList<>();
		produtos = produtoRepository.findAll();
		for(Produto p : produtos){

			produtoDTOS.add(p.toProdutoDTO());
		}
		return produtoDTOS;
	}
	
	
	public List<Produto> estoque (){
		List<Produto> estoque = produtoRepository.findAll();
		return estoque;
	}
	
	
	public Produto findById(Long id){
		Produto produto = new Produto();
		produto = produtoRepository.findById(id).get();
		return produto;
	}
	
	public Produto editar(Produto produto) {
		Produto produtoEditado = produtoRepository.save(produto);
		return produtoEditado;
	}

}
