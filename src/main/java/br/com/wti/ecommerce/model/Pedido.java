package br.com.wti.ecommerce.model;

import jakarta.persistence.Column;
import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;
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
@Table(name = "pedido")
public class Pedido {

  @EqualsAndHashCode.Include
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Integer id;

  @ManyToOne(optional = false)
  @JoinColumn(name = "cliente_id")
  private Cliente cliente;

  @OneToMany(mappedBy = "pedido")
  private List<ItemPedido> itens;

  @Column(name = "data_pedido")
  private LocalDateTime dataPedido;

  @Column(name = "data_conclusao")
  private LocalDateTime dataConclusao;

  @OneToOne(mappedBy = "pedido")
  private NotaFiscal notaFiscal;

  private BigDecimal total;

  @Enumerated(EnumType.STRING)
  private StatusPedido status;

  @OneToOne(mappedBy = "pedido")
  private PagamentoCartao pagamento;

  @Embedded
  private EnderecoEntregaPedido enderecoEntrega;
}
