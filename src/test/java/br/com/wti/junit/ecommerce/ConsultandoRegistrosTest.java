package br.com.wti.junit.ecommerce;

import br.com.wti.ecommerce.model.Produto;
import br.com.wti.junit.EntityManagerTest;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * @author Washington Antunes for wTI on 12/07/2023
 */
public class ConsultandoRegistrosTest extends EntityManagerTest {

  @Test
  public void buscarPorIdentificador() {
    Produto produto = entityManager.find(Produto.class, 1);
//    Produto produto = entityManager.getReference(Produto.class, 1);

    Assertions.assertNotNull(produto);
    Assertions.assertEquals("Kindle", produto.getNome());
  }

  @Test
  public void atualizaAReferencia() {
    Produto produto = entityManager.find(Produto.class, 1);
    produto.setNome("Microfone Samson");

    entityManager.refresh(produto);

    Assertions.assertEquals("Kindle", produto.getNome());
  }
}
