package br.com.wti.ecommerce.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import java.util.Date;
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
@Table(name = "nota_fiscal")
public class NotaFiscal {

  @EqualsAndHashCode.Include
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Integer id;

  @OneToOne(optional = false)
  @JoinColumn(name = "pedido_id")
//  @JoinTable(name = "pedido_nota_fiscal",
//          joinColumns = @JoinColumn(name = "nota_fiscal_id", unique = true),
//          inverseJoinColumns = @JoinColumn(name = "pedido_id", unique = true))
  private Pedido pedido;

  private String xml;

  @Column(name = "data_emissao")
  private Date dataEmissao;
}
