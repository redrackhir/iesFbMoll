/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package yatzy;

import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author soib1a20
 */
public class YatzyTest {
    
    @Test
    public void chance_suma_todos_los_dados() {
        int esperado = 14;
        int actual = Yatzy.chance(1,1,3,3,6);
        assertEquals(esperado, actual);
        assertEquals(21, Yatzy.chance(4,5,5,6,1));
    }
    
    @Test
    public void yatzy_todos_dados_iguales_50_sino_0() {
        int esperado = 50;
        int actual = Yatzy.yatzy(1,1,1,1,1);
        assertEquals(esperado,actual);
        assertEquals(50,Yatzy.yatzy(2,2,2,2,2));
        assertEquals(50,Yatzy.yatzy(4,4,4,4,4));
        assertEquals(0,Yatzy.yatzy(2,4,4,4,4));
        assertEquals(0,Yatzy.yatzy(4,4,4,2,4));
        assertEquals(0,Yatzy.yatzy(4,1,4,4,4));
        assertEquals(0,Yatzy.yatzy(4,4,4,4,6));
    }
    
    @Test
    public void unos() {
        int esperado = 2;
        int actual = Yatzy.ones(1,1,2,3,4);
        assertEquals(esperado,actual);
        assertEquals(3,Yatzy.ones(1,1,1,4,5));
        assertEquals(4,Yatzy.ones(1,1,1,1,5));
        assertEquals(5,Yatzy.ones(1,1,1,1,1));
        assertEquals(1,Yatzy.ones(2,4,5,3,1));
    }
    
    
}
