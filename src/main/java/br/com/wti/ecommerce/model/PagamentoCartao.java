package br.com.wti.ecommerce.model;

import jakarta.persistence.Column;
import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.Setter;

/**
 * @author Washington Antunes for wTI on 12/07/2023
 */

@Getter
@Setter
@DiscriminatorValue(("cartao"))
@Entity
public class PagamentoCartao extends Pagamento {


    @Column(name = "numero_cartao", length = 50)
    private String numeroCartao;
}
