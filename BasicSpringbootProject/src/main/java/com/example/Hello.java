/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 *
 * @author soib1a20
 */
@Controller
public class Hello {

    private final String LINKS = "<a href='../login?username=Usuario'>login</a>&nbsp;&nbsp;"
            + "<a href='../report'>informes</a>";
    private final String CABECERA = "<h1 align='center'>Welcome to incredible Spring!</h1>"
            + "<h4 align='center'><i>by r3drackhir</i></h4></br>";
    private final String BODY_OPEN = "<div align='center' bgcolor='#eeeeee'>";
    private final String BODY_CLOSE = "</div>";

    @RequestMapping("/")
    @ResponseBody
    public String index() {
        return CABECERA 
                + BODY_OPEN 
                + "Esto es la página principal."
                + BODY_CLOSE 
                + LINKS;
    }

    @RequestMapping("/report")
    @ResponseBody
    public String showList() {
        return CABECERA
                + "</br>"
                + BODY_OPEN
                + "<table>"
                + "<th>Campo #1</th>"
                + "<th>Campo #2</th>"
                + "<th>Campo #3</th>"
                + "<tr>"
                + "<td>Celda #1</td>"
                + "<td>Celda #2</td>"
                + "<td>Celda #3</td>"
                + "</tr>"
                + "</table><br>"
                + BODY_CLOSE
                + LINKS;
    }

    @RequestMapping(value = "/login", method = RequestMethod.GET)
    @ResponseBody
    public String recoverPass(@RequestParam("username") String username) {
        return CABECERA
                + BODY_OPEN
                + "Welcome mr." + username
                + BODY_CLOSE
                + LINKS;
    }

}
