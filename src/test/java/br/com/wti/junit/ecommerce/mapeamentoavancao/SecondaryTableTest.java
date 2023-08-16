package br.com.wti.junit.ecommerce.mapeamentoavancao;

import br.com.wti.ecommerce.model.Cliente;
import br.com.wti.ecommerce.model.SexoCliente;
import br.com.wti.junit.EntityManagerTest;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

/**
 * @author Washington Antunes for wTI on 07/08/2023
 */
public class SecondaryTableTest extends EntityManagerTest {

    @Test
    public void salvarCliente() {
        Cliente cliente = new Cliente();
        cliente.setNome("Carlos Finotti");
        cliente.setSexo(SexoCliente.MASCULINO);
        cliente.setCpf("555");
        cliente.setDataNascimento(LocalDate.of(1990,1,1));

        entityManager.getTransaction().begin();
        entityManager.persist(cliente);
        entityManager.getTransaction().commit();

        entityManager.clear();

        Cliente clienteVerificacao = entityManager.find(Cliente.class, cliente.getId());
        Assertions.assertNotNull(clienteVerificacao.getSexo());
    }
}
