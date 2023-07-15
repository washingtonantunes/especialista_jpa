package br.com.wti.junit.ecommerce.relacionamentos;

import br.com.wti.ecommerce.model.Pedido;
import br.com.wti.junit.EntityManagerTest;
import org.junit.jupiter.api.Test;

/**
 * @author Washington Antunes for wTI on 15/07/2023
 */
public class EagerELazyTest extends EntityManagerTest {

  @Test
  public void verificarComportamento() {
    Pedido pedido = entityManager.find(Pedido.class, 1);
    System.out.println("pedido carregado");

    System.out.println();
    pedido.getItens().isEmpty();
    System.out.println("itens carregado");
  }
}
