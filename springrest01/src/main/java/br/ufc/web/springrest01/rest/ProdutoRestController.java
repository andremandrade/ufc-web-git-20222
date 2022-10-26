package br.ufc.web.springrest01.rest;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import br.ufc.web.springrest01.model.Produto;
import br.ufc.web.springrest01.service.ProdutoService;

@RestController
@RequestMapping("/api/produto")
public class ProdutoRestController {
    
    @Autowired
    ProdutoService produtoService;

    @GetMapping
    List<Produto> getProdutos(@RequestParam Map<String, String> params){
        String buscaNome = null;
        if(params.get("nome") != null){
            buscaNome = params.get("nome");
        }
        return produtoService.getProdutos(buscaNome);
    }

    @GetMapping(path = "/{id}")
    Produto getProduto(@PathVariable String id){
        return produtoService.getProduto(Integer.parseInt(id));
    }

    @PostMapping
    void addProduto(@RequestBody Produto produto){
        produtoService.addProduto(produto);
    }

    @PutMapping(path = "/{id}")
    void updateProduto(@PathVariable String id, @RequestBody Produto produto){
        produtoService.updateProduto(Integer.parseInt(id), produto);
    }

    @DeleteMapping(path = "/{id}")
    Produto deleteProduto(@PathVariable String id){
        return produtoService.deleteProduto(Integer.parseInt(id));
    }

}
