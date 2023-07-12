package br.com.wti.junit;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 * @author Washington Antunes for wTI on 12/07/2023
 */
public class EntendendoJUnitTest {

  @BeforeClass
  public static void iniciarTestes() {
    System.out.println(">>> public void iniciarTestes() <<<");
  }

  @AfterClass
  public static void encerrarTestes() {
    System.out.println(">>> public void encerrarTestes() <<<");
  }

  @Before
  public void iniciarTeste() {
    System.out.println(">>> public void iniciarTeste() <<<");
  }

  @After
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
