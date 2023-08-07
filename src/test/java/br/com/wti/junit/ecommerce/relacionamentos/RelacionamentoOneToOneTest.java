package br.com.wti.junit.ecommerce.relacionamentos;

import br.com.wti.ecommerce.model.NotaFiscal;
import br.com.wti.ecommerce.model.PagamentoCartao;
import br.com.wti.ecommerce.model.Pedido;
import br.com.wti.ecommerce.model.StatusPagamento;
import br.com.wti.junit.EntityManagerTest;
import java.util.Date;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * @author Washington Antunes for wTI on 15/07/2023
 */
public class RelacionamentoOneToOneTest extends EntityManagerTest {

  @Test
  public void verificarRelacionamento() {
    Pedido pedido = entityManager.find(Pedido.class, 1);

    PagamentoCartao pagamentoCartao = new PagamentoCartao();
    pagamentoCartao.setNumeroCartao("1234");
    pagamentoCartao.setStatus(StatusPagamento.PROCESSANDO);
    pagamentoCartao.setPedido(pedido);

    entityManager.getTransaction().begin();
    entityManager.persist(pagamentoCartao);
    entityManager.getTransaction().commit();

    entityManager.clear();

    Pedido pedidoVerificacao = entityManager.find(Pedido.class, pedido.getId());
    Assertions.assertNotNull(pedidoVerificacao.getPagamento());
  }

  @Test
  public void verificarRelacionamentoPedidoNotaFiscal() {
    Pedido pedido = entityManager.find(Pedido.class, 1);

    NotaFiscal notaFiscal = new NotaFiscal();
    notaFiscal.setXml("TESTE".getBytes());
    notaFiscal.setDataEmissao(new Date());
    notaFiscal.setPedido(pedido);

    entityManager.getTransaction().begin();
    entityManager.persist(notaFiscal);
    entityManager.getTransaction().commit();

    entityManager.clear();

    Pedido pedidoVerificacao = entityManager.find(Pedido.class, pedido.getId());
    Assertions.assertNotNull(pedidoVerificacao.getNotaFiscal());
  }
}
