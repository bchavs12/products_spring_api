package br.com.gestao_produto.gestaoProduto.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;

import lombok.*;

import java.io.Serializable;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "Produtos")
public class Produto implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull(message = "Nome não pode ser nulo")
    @NotBlank(message = "Nome não pode estar vazio")
    private String nome;

    @NotNull(message = "Preço não pode ser nulo")
    @Positive(message = "Preço deve ser positivo")
    private Double preco;
}
