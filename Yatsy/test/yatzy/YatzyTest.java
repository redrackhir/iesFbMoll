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
        int actual = Yatzy.chance(1, 1, 3, 3, 6);
        assertEquals(esperado, actual);
        assertEquals(21, Yatzy.chance(4, 5, 5, 6, 1));
    }

    @Test
    public void yatzy_todos_dados_iguales_50_sino_0() {
        int esperado = 50;
        int actual = Yatzy.yatzy(1, 1, 1, 1, 1);
        assertEquals(esperado, actual);
        assertEquals(50, Yatzy.yatzy(2, 2, 2, 2, 2));
        assertEquals(50, Yatzy.yatzy(4, 4, 4, 4, 4));
        assertEquals(0, Yatzy.yatzy(2, 4, 4, 4, 4));
        assertEquals(0, Yatzy.yatzy(4, 4, 4, 2, 4));
        assertEquals(0, Yatzy.yatzy(4, 1, 4, 4, 4));
        assertEquals(0, Yatzy.yatzy(4, 4, 4, 4, 6));
    }

    @Test
    public void unos_puntua_todos_los_dados_mismo_nro() {
        int esperado = 2;
        int actual = Yatzy.ones(1, 1, 2, 3, 4);
        assertEquals(esperado, actual);
        assertEquals(3, Yatzy.ones(1, 1, 1, 4, 5));
        assertEquals(4, Yatzy.ones(1, 1, 1, 1, 5));
        assertEquals(5, Yatzy.ones(1, 1, 1, 1, 1));
        assertEquals(1, Yatzy.ones(2, 4, 5, 3, 1));
    }

    @Test
    public void doses_puntua_todos_los_dados_mismo_nro() {
        int esperado = 2;
        int actual = Yatzy.twos(2, 1, 2, 3, 6);
        assertEquals(esperado, actual);
        assertEquals(3, Yatzy.twos(1, 2, 2, 2, 5));
        assertEquals(4, Yatzy.twos(2, 2, 1, 2, 2));
        assertEquals(5, Yatzy.twos(2, 2, 2, 2, 2));
        assertEquals(1, Yatzy.twos(2, 4, 5, 3, 1));
    }

    @Test
    public void treses_puntua_todos_los_dados_mismo_nro() {
        int esperado = 2;
        int actual = Yatzy.threes(3, 1, 2, 3, 6);
        assertEquals(esperado, actual);
        assertEquals(3, Yatzy.threes(3, 3, 3, 2, 5));
        assertEquals(4, Yatzy.threes(2, 3, 3, 3, 3));
        assertEquals(5, Yatzy.threes(3, 3, 3, 3, 3));
        assertEquals(1, Yatzy.threes(2, 4, 5, 3, 1));
    }

    @Test
    public void cuatros_puntua_todos_los_dados_mismo_nro() {
        int esperado = 2;
        int actual = Yatzy.fours(4, 1, 2, 4, 6);
        assertEquals(esperado, actual);
        assertEquals(3, Yatzy.fours(4, 4, 4, 2, 5));
        assertEquals(4, Yatzy.fours(2, 4, 4, 4, 4));
        assertEquals(5, Yatzy.fours(4, 4, 4, 4, 4));
        assertEquals(1, Yatzy.fours(2, 4, 5, 3, 1));
    }

    @Test
    public void cincos_puntua_todos_los_dados_mismo_nro() {
        int esperado = 0;
        int actual = Yatzy.fives(4, 1, 2, 4, 6);
        assertEquals(esperado, actual);
        assertEquals(3, Yatzy.fives(5, 5, 5, 2, 3));
        assertEquals(4, Yatzy.fives(2, 5, 5, 5, 5));
        assertEquals(5, Yatzy.fives(5, 5, 5, 5, 5));
        assertEquals(2, Yatzy.fives(2, 5, 5, 3, 1));
    }

    @Test
    public void seises_puntua_todos_los_dados_mismo_nro() {
        int esperado = 2;
        int actual = Yatzy.sixes(6, 1, 2, 6, 4);
        assertEquals(esperado, actual);
        assertEquals(3, Yatzy.sixes(6, 6, 6, 2, 5));
        assertEquals(4, Yatzy.sixes(2, 6, 6, 6, 6));
        assertEquals(5, Yatzy.sixes(6, 6, 6, 6, 6));
        assertEquals(1, Yatzy.sixes(2, 6, 5, 3, 1));
    }

    @Test
    public void pares_puntua_cualquier_par() {
        int esperado = 4;
        int actual = Yatzy.pair(2, 1, 2, 6, 4);
        assertEquals("2, 1, 2, 6, 4", esperado, actual);
        assertEquals("6, 6, 4, 2, 5", 12, Yatzy.pair(6, 6, 4, 2, 5));
        assertEquals("2, 6, 6, 6, 4", 12, Yatzy.pair(2, 6, 6, 6, 4));
        assertEquals("2, 4, 6, 4, 1", 8, Yatzy.pair(2, 4, 6, 4, 1));
        assertEquals("3, 3, 3, 3, 1", 6, Yatzy.pair(3, 3, 3, 3, 1));
    }

    @Test
    public void dos_pares_puntua_dos_pares_cualquiera() {
        assertEquals("1, 1, 2, 3, 3", 8, Yatzy.twoPairs(1, 1, 2, 3, 3));
        assertEquals("1, 1, 2, 3, 4", 0, Yatzy.twoPairs(1, 1, 2, 3, 4));
        assertEquals("1, 1, 2, 2, 2", 6, Yatzy.twoPairs(1, 1, 2, 2, 2));
    }

    @Test
    public void trio_puntua_tres_dados_iguales() {
        assertEquals(9, Yatzy.threeOfKind(3, 3, 3, 4, 5));
        assertEquals(0, Yatzy.threeOfKind(3, 3, 4, 5, 6));
        assertEquals(9, Yatzy.threeOfKind(3, 3, 3, 3, 1));
    }

    @Test
    public void cuarteto_puntua_cuatro_dados_iguales() {
        assertEquals(8, Yatzy.fourOfKind(2,2,2,2,5));
        assertEquals(0, Yatzy.fourOfKind(2,2,2,5,5 ));
        assertEquals(8, Yatzy.fourOfKind(2,2,2,2,2));
    }

    @Test
    public void escalera_menor_puntua_de_1_a_5() {
        assertEquals(15, Yatzy.smallStraight(1,2,3,4,5));
        assertEquals(15, Yatzy.smallStraight(5,4,3,2,1 ));
        assertEquals(0, Yatzy.smallStraight(1,2,3,6,5));
    }

    @Test
    public void escalera_mayor_puntua_de_2_a_6() {
        assertEquals(20, Yatzy.largeStraight(6,2,3,4,5));
        assertEquals(20, Yatzy.largeStraight(5,2,4,3,6 ));
        assertEquals(0, Yatzy.largeStraight(1,2,3,6,5));
    }

    @Test
    public void full_puntua_un_trio_con_un_par() {
        assertEquals(8, Yatzy.fullHouse(1,1,2,2,2));
        assertEquals(0, Yatzy.fullHouse(2,2,3,3,4 ));
        assertEquals(0, Yatzy.fullHouse(4,4,4,4,4));
        assertEquals(23, Yatzy.fullHouse(4,4,5,5,5));
    }

}
