/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package prv_bit2decimal;

import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author soib1a20
 */
public class MainTest {
    
    public MainTest() {
    }
    

public class MiddleExampleTests {
  @Test
  public void evenTests() {
    assertEquals("es", Main.getMiddle("test"));
    assertEquals("dd", Main.getMiddle("middle"));
  }
  
  @Test
  public void oddTests() {
    assertEquals("t", Main.getMiddle("testing"));
    assertEquals("A", Main.getMiddle("A"));
  }
}    
}
