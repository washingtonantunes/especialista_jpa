package br.com.wti.ecommerce.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import java.math.BigDecimal;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

/**
 * @author Washington Antunes for wTI on 12/07/2023
 */

@Getter
@Setter
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Entity
public class Produto {

  @EqualsAndHashCode.Include
  @Id
  private Integer id;
  private String nome;
  private String descricao;
  private BigDecimal preco;
}
