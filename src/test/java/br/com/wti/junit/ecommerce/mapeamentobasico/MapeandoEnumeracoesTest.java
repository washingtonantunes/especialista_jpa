package br.com.wti.junit.ecommerce.mapeamentobasico;

import br.com.wti.ecommerce.model.Cliente;
import br.com.wti.ecommerce.model.SexoCliente;
import br.com.wti.junit.EntityManagerTest;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * @author Washington Antunes for wTI on 15/07/2023
 */
public class MapeandoEnumeracoesTest extends EntityManagerTest {

  @Test
  public void testarEnum() {
    Cliente cliente = new Cliente();
    cliente.setNome("José Mineiro");
    cliente.setCpf("666");
    cliente.setSexo(SexoCliente.MASCULINO);

    entityManager.getTransaction().begin();
    entityManager.persist(cliente);
    entityManager.getTransaction().commit();

    entityManager.clear();

    Cliente clienteVerificacao = entityManager.find(Cliente.class, cliente.getId());
    Assertions.assertNotNull(clienteVerificacao);
  }
}
