/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package codewars;

import java.awt.geom.Point2D;

/**
 *
 * @author red rackhir
 */
public class StreetFighter {

    private static String[][] fighters = {{"Ryu", "E.Honda", "Blanka", "Guile", "Balrog", "Vega"},
    {"Ken", "Chun Li", "Zangief", "Dhalsim", "Sagat", "M.Bison"}};
    Point2D.Double position;

    public static String[] selection(String[] moves) {
        int x = 0, y = 0; String retVal= "";
        for (String move : moves) {
            switch (move.toLowerCase()) {
                case "left":
                    x--; if(x<0) {x=5;}
                    break;
                case "right":
                    x++; if(x>5) {x=0;}
                    break;
                case "down":
                    y++; if(y>1) {y=0;}
                    break;
                case "up":
                    y--; if(y<0) {y=1;}
            }
            retVal+=retVal.length()==0? fighters[y][x]:","+fighters[y][x];
        }

        return retVal.split(",");
    }
}
