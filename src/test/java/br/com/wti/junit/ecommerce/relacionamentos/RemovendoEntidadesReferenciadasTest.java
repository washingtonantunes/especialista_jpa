package br.com.wti.junit.ecommerce.relacionamentos;

import br.com.wti.ecommerce.model.Pedido;
import br.com.wti.junit.EntityManagerTest;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * @author Washington Antunes for wTI on 15/07/2023
 */
public class RemovendoEntidadesReferenciadasTest extends EntityManagerTest {

  @Test
  public void removerEntidadeRelacionada() {
    Pedido pedido = entityManager.find(Pedido.class, 1);

    Assertions.assertFalse(pedido.getItens().isEmpty());

    entityManager.getTransaction().begin();
    pedido.getItens().forEach(i -> entityManager.remove(i));
    entityManager.remove(pedido);
    entityManager.getTransaction().commit();

    entityManager.clear();

    Pedido pedidoVerificacao = entityManager.find(Pedido.class, 1);
    Assertions.assertNull(pedidoVerificacao);
  }
}
