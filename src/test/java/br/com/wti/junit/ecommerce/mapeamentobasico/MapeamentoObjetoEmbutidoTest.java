package br.com.wti.junit.ecommerce.mapeamentobasico;

import br.com.wti.ecommerce.model.EnderecoEntregaPedido;
import br.com.wti.ecommerce.model.Pedido;
import br.com.wti.ecommerce.model.StatusPedido;
import br.com.wti.junit.EntityManagerTest;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * @author Washington Antunes for wTI on 15/07/2023
 */
public class MapeamentoObjetoEmbutidoTest extends EntityManagerTest {

  @Test
  public void analisarMapeamentoObjetoEmbutido() {
    EnderecoEntregaPedido endereco = new EnderecoEntregaPedido();
    endereco.setCep("00000-00");
    endereco.setLogradouro("Rua das Laranjeiras");
    endereco.setNumero("123");
    endereco.setBairro("Centro");
    endereco.setCidade("Uberlândia");
    endereco.setEstado("MG");

    Pedido pedido = new Pedido();
    pedido.setDataPedido(LocalDateTime.now());
    pedido.setStatus(StatusPedido.AGUARDANDO);
    pedido.setTotal(new BigDecimal(1000));
    pedido.setEnderecoEntrega(endereco);

    entityManager.getTransaction().begin();
    entityManager.persist(pedido);
    entityManager.getTransaction().commit();

    entityManager.clear();

    Pedido pedidoVerificacao = entityManager.find(Pedido.class, pedido.getId());
    Assertions.assertNotNull(pedidoVerificacao);
    Assertions.assertNotNull(pedidoVerificacao.getEnderecoEntrega());
    Assertions.assertNotNull(pedidoVerificacao.getEnderecoEntrega().getCep());
  }
}
