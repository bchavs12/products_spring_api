package br.com.gestao_produto.gestaoProduto.service;

import br.com.gestao_produto.gestaoProduto.exception.ProdutoNaoEncontradoException;
import br.com.gestao_produto.gestaoProduto.model.Produto;
import br.com.gestao_produto.gestaoProduto.repository.ProdutoRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProdutoService {

    private final ProdutoRepository repository;

    public ProdutoService(ProdutoRepository repository) {
        this.repository = repository;
    }

    public List<Produto> listarProdutos() {
        return repository.findAll();
    }

    // Salva 1 objeto(JSON) por vez
    public Produto salvarProduto(Produto produto) {

        return repository.save(produto);
    }

    // Salva varios objeto(JSON) por vez
    public List<Produto> salvarLote(List<Produto> produto) {

        if (produto == null || produto.isEmpty()) {
            throw new IllegalArgumentException("dados do produto invalidos ou vazios!");
        }

        return repository.saveAll(produto);
    }

    public Optional<Produto> editarProduto(Produto produto) throws ProdutoNaoEncontradoException {
        Produto produtoAtualizado = repository.findById(produto.getId())
                .orElseThrow(() -> new ProdutoNaoEncontradoException("Produto não encontrado!"));

        // Atualiza os campos
        produtoAtualizado.setNome(produto.getNome());
        produtoAtualizado.setPreco(produto.getPreco());

        // Persiste a atualização no Banco de dados
        return Optional.of(repository.save(produtoAtualizado));
    }

    public void deletarProduto(Long id) throws ProdutoNaoEncontradoException {
        if (!repository.existsById(id)) {
            throw new ProdutoNaoEncontradoException("Produto não encontrado!");
        }

        repository.deleteById(id);
    }

}
