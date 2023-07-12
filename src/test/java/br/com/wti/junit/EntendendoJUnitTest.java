package br.com.wti.junit;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * @author Washington Antunes for wTI on 12/07/2023
 */
public class EntendendoJUnitTest {

  @BeforeAll
  public static void iniciarTestes() {
    System.out.println(">>> public void iniciarTestes() <<<");
  }

  @AfterAll
  public static void encerrarTestes() {
    System.out.println(">>> public void encerrarTestes() <<<");
  }

  @BeforeEach
  public void iniciarTeste() {
    System.out.println(">>> public void iniciarTeste() <<<");
  }

  @AfterEach
  public void encerrarTeste() {
    System.out.println(">>> public void encerrarTeste() <<<");
  }

  @Test
  public void testandoAlgo() {
    System.out.println(">>> public void testandoAlgo() <<<");
  }

  @Test
  public void testandoOutraCoisa() {
    System.out.println(">>> public void testandoOutraCoisa() <<<");
  }
}
