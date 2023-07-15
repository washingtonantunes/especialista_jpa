package br.com.wti.ecommerce.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import java.math.BigDecimal;
import java.util.List;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.boot.model.source.spi.EmbeddableSource;

/**
 * @author Washington Antunes for wTI on 12/07/2023
 */

@Getter
@Setter
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Entity
@Table(name = "produto")
public class Produto {

  @EqualsAndHashCode.Include
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Integer id;
  private String nome;
  private String descricao;
  private BigDecimal preco;

  @ManyToMany
  @JoinTable(name = "produto_categoria",
          joinColumns = @JoinColumn(name = "produto_id"),
          inverseJoinColumns = @JoinColumn(name = "categoria_id"))
  private List<Categoria> categorias;

  @OneToOne(mappedBy = "produto")
  private Estoque estoque;
}
