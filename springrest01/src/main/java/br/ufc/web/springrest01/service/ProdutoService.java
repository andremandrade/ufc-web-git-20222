package br.ufc.web.springrest01.service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Service;

import br.ufc.web.springrest01.model.Produto;

@Service
public class ProdutoService {
    
    private List<Produto> produtos = new ArrayList<Produto>();
	
	public ProdutoService() {
		produtos.addAll(Arrays.asList(new Produto(1, "Livro", 200f), new Produto(2, "Laptop", 938752.67f), new Produto(3, "Bicicleta", 12400f)));
	}
	
	public List<Produto> getProdutos(String nome) {
        if(nome != null){
            List<Produto> buscaProdutos = new ArrayList<Produto>();
            for (Produto produto : produtos) {
                if(produto.getNome().toUpperCase().contains(nome.toUpperCase()))
                    buscaProdutos.add(produto);
            }
            return buscaProdutos;
        } else return produtos;
	}

	public void addProduto(Produto produto) {
		produtos.add(produto);
	}

    public Produto getProduto(int id) {
        for (Produto produto : produtos) {
            if(produto.getId() == id)
                return produto;
        }
        return null;
    }

    public void updateProduto(int id, Produto novo) {
        for (Produto produto : produtos) {
            if(produto.getId() == id)
            {
                produto.setNome(novo.getNome());
                produto.setPreco(novo.getPreco());
                return;
            }
        }
    }

    public Produto deleteProduto(int id) {
        for (int i = 0; i < produtos.size(); i++) {
            Produto p = produtos.get(i);
            if(p.getId() == id){
                produtos.remove(p);
                return p;
            }
        }
        return null;
    }

}
