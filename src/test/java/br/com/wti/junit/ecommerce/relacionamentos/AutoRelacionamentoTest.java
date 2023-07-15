package br.com.wti.junit.ecommerce.relacionamentos;

import br.com.wti.ecommerce.model.Categoria;
import br.com.wti.junit.EntityManagerTest;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * @author Washington Antunes for wTI on 15/07/2023
 */
public class AutoRelacionamentoTest extends EntityManagerTest {

  @Test
  public void verificarRelacionamento() {
    Categoria categoriaPai = new Categoria();
    categoriaPai.setNome("Eletrônicos");

    Categoria categoria = new Categoria();
    categoria.setNome("Celulares");
    categoria.setCategoriaPai(categoriaPai);

    entityManager.getTransaction().begin();
    entityManager.persist(categoriaPai);
    entityManager.persist(categoria);
    entityManager.getTransaction().commit();

    entityManager.clear();

    Categoria categoriaVerificacao = entityManager.find(Categoria.class, categoria.getId());
    Assertions.assertNotNull(categoriaVerificacao.getCategoriaPai());

    Categoria categoriaPaiVerificacao = entityManager.find(Categoria.class, categoriaPai.getId());
    Assertions.assertFalse(categoriaPaiVerificacao.getCategorias().isEmpty());
  }
}
