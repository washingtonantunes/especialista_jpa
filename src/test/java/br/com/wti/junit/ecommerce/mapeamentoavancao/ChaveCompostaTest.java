package br.com.wti.junit.ecommerce.mapeamentoavancao;

import br.com.wti.ecommerce.model.Cliente;
import br.com.wti.ecommerce.model.ItemPedido;
import br.com.wti.ecommerce.model.ItemPedidoId;
import br.com.wti.ecommerce.model.Pedido;
import br.com.wti.ecommerce.model.Produto;
import br.com.wti.ecommerce.model.StatusPedido;
import br.com.wti.junit.EntityManagerTest;

import java.time.LocalDateTime;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * @author Washington Antunes for wTI on 17/07/2023
 */
public class ChaveCompostaTest extends EntityManagerTest {

    @Test
    public void salvarItem() {
        Cliente cliente = entityManager.find(Cliente.class, 1);
        Produto produto = entityManager.find(Produto.class, 1);

        Pedido pedido = new Pedido();
        pedido.setDataCriacao(LocalDateTime.now());
        pedido.setCliente(cliente);
        pedido.setDataCriacao(LocalDateTime.now());
        pedido.setStatus(StatusPedido.AGUARDANDO);
        pedido.setTotal(produto.getPreco());

        ItemPedido itemPedido = new ItemPedido();
//    itemPedido.setPedidoId(pedido.getId()); IdClass
//    itemPedido.setProdutoId(produto.getId()); IdClass
        itemPedido.setId(new ItemPedidoId());
        itemPedido.setPedido(pedido);
        itemPedido.setProduto(produto);
        itemPedido.setPrecoProduto(produto.getPreco());
        itemPedido.setQuantidade(1);

        entityManager.getTransaction().begin();
        entityManager.persist(pedido);
        entityManager.persist(itemPedido);
        entityManager.getTransaction().commit();

        entityManager.clear();

        Pedido pedidoVerificacao = entityManager.find(Pedido.class, pedido.getId());
        Assertions.assertNotNull(pedidoVerificacao);
        Assertions.assertFalse(pedidoVerificacao.getItens().isEmpty());
    }

    @Test
    public void bucarItem() {
        ItemPedido itemPedido = entityManager.find(ItemPedido.class, new ItemPedidoId(1, 1));

        Assertions.assertNotNull(itemPedido);
    }
}
