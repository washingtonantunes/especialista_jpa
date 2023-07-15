package br.com.wti.junit.ecommerce.mapeamentobasico;

import br.com.wti.ecommerce.model.Categoria;
import br.com.wti.junit.EntityManagerTest;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * @author Washington Antunes for wTI on 15/07/2023
 */
public class EstrategiaChavePrimariaTest extends EntityManagerTest {

  @Test
  public void testarEstrategiaChave() {
    Categoria categoria = new Categoria();
    categoria.setNome("Eletrônicos");

    entityManager.getTransaction().begin();
    entityManager.persist(categoria);
    entityManager.getTransaction().commit();

    entityManager.clear();

    Categoria categoriaVerificacao = entityManager.find(Categoria.class, categoria.getId());
    Assertions.assertNotNull(categoriaVerificacao);
  }
}
