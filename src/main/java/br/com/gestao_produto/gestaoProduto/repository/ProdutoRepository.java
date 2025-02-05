package br.com.gestao_produto.gestaoProduto.repository;

import br.com.gestao_produto.gestaoProduto.model.Produto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProdutoRepository extends JpaRepository<Produto, Long> {
}
