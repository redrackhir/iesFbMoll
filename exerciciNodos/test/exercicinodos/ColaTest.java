/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package exercicinodos;

import org.junit.AfterClass;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.BeforeClass;

/**
 *
 * @author soib1a20
 */
public class ColaTest {

    private static Cola cola = new Cola();
    private static final Nodo N1 = new Nodo("primero");
    private static final Nodo N2 = new Nodo("segundo");
    private static final Nodo N3 = new Nodo("tercero");
    private static final Nodo N4 = new Nodo("cuarto");
    private static final Nodo N5 = new Nodo("quinto");
    private static final Nodo N6 = new Nodo("sexto");

    public ColaTest() {
        cola = new Cola();
        System.out.println("Constructor");
    }

    @BeforeClass
    public static void setUpClass() throws Exception {
        System.out.println("BeforeClass");
    }

    @AfterClass
    public static void tearDownClass() throws Exception {
    }

    /**
     * Test of add method, of class Cola.
     */
    @Test
    public void testAdd() {
        int expected = 1;
        int actual;

        System.out.println("add");

        System.out.println(N1);
        cola.add(N1);
        actual = cola.size();
        assertEquals(expected, actual);

        cola.add(N2);
        assertEquals(2, cola.size());
        cola.add(N3);
        assertEquals(3, cola.size());
        cola.add(N4);
        assertEquals(4, cola.size());
        cola.add(N5);
        assertEquals(5, cola.size());
        cola.add(N6);
        assertEquals(6, cola.size());
    }

    public void testCerca() {
        Nodo expected = N2;
        Nodo result = cola.cerca(N2.info);
        assertEquals(expected, result);

        assertEquals(null, "inexistente");
    }

    public void testGetFirst() {
        fillData();
        assertEquals(N1, cola.getFirst());
    }

    public void testGetLast() {
        fillData();
        assertEquals(N1, cola.getLast());
    }

    private void fillData() {
        cola.add(N1);
        cola.add(N2);
        cola.add(N3);
        cola.add(N4);
        cola.add(N5);
        cola.add(N6);
    }

}
