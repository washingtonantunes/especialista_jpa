package br.com.wti.ecommerce.model;

import jakarta.persistence.Embeddable;
import lombok.Getter;
import lombok.Setter;

/**
 * @author Washington Antunes for wTI on 15/07/2023
 */
@Getter
@Setter
@Embeddable
public class EnderecoEntregaPedido {

  private String cep;

  private String logradouro;

  private String numero;

  private String complemento;

  private String bairro;

  private String cidade;

  private String estado;
}
