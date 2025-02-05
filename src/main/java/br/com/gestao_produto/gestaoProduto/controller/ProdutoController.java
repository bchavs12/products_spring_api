package br.com.gestao_produto.gestaoProduto.controller;

import br.com.gestao_produto.gestaoProduto.model.Produto;
import br.com.gestao_produto.gestaoProduto.service.ProdutoService;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/produtos")
public class ProdutoController {

    private final ProdutoService service;

    public ProdutoController(ProdutoService service) {
        this.service = service;
    }

    @GetMapping("/")
    public List<Produto> listarProdutos(){
        return service.listarProdutos();
    }

    @PostMapping("/")
    public Produto salvarProduto(@RequestBody @Valid Produto produto){
        return service.salvarProduto(produto);
    }

    @PostMapping("/lote")
    private List<Produto> salvarLote(@RequestBody @Valid List<Produto> lote){
        return service.salvarLote(lote);
    }

}
