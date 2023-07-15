package br.com.wti.ecommerce.util;

import br.com.wti.ecommerce.model.Produto;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

/**
 * @author Washington Antunes for wTI on 15/07/2023
 */
public class IniciarUnidadeDePersistencia {

  public static void main(String[] args) {
    EntityManagerFactory entityManagerFactory = Persistence
        .createEntityManagerFactory("Ecommerce-PU");
    EntityManager entityManager = entityManagerFactory.createEntityManager();

    Produto produto = entityManager.find(Produto.class, 1);
    System.out.println(produto.getNome());

    entityManager.close();
    entityManagerFactory.close();
  }
}
