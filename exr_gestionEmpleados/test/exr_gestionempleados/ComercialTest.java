/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package exr_gestionempleados;

import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author soib1a20
 */
public class ComercialTest {

    public ComercialTest() {
    }

    @BeforeClass
    public static void setUpClass() {
    }

    /**
     * Test of getPlus method, of class Comercial.
     */
    @Test
    public void testGetPlus() {
        System.out.println("getPlus");
        Comercial instance = new Comercial("Juan", 28, 800, 210);
        double expResult = 0.0;
        double result = instance.getPlus();
        assertEquals(expResult, result, 0.0);
        assertEquals(300.0, new Comercial("Estefano", 31, 875, 215).getPlus(), 0.0);
    }

}
