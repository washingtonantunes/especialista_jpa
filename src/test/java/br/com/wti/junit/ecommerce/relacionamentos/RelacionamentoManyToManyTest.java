package br.com.wti.junit.ecommerce.relacionamentos;

import br.com.wti.ecommerce.model.Categoria;
import br.com.wti.ecommerce.model.Produto;
import br.com.wti.junit.EntityManagerTest;
import java.util.Arrays;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * @author Washington Antunes for wTI on 15/07/2023
 */
public class RelacionamentoManyToManyTest extends EntityManagerTest {

  @Test
  public void verificarRelacionamento() {
    Produto produto = entityManager.find(Produto.class, 1);
    Categoria categoria = entityManager.find(Categoria.class, 1);

    entityManager.getTransaction().begin();
    produto.setCategorias(Arrays.asList(categoria));
    entityManager.getTransaction().commit();

    entityManager.clear();

    Categoria categoriaVerificacao = entityManager.find(Categoria.class, categoria.getId());
    Assertions.assertFalse(categoriaVerificacao.getProdutos().isEmpty());
  }
}
