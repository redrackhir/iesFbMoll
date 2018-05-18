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

    @RequestMapping("/")
    @ResponseBody
    public String index() {
        return "Greetings from Spring Boot!";
    }

    @RequestMapping("/report")
    @ResponseBody
    public String showList() {
        return "<table>"
                + "<th>Campo #1</th>"
                + "<th>Campo #2</th>"
                + "<th>Campo #3</th>"
                + "<tr>"
                + "<td>Celda #1</td>"
                + "<td>Celda #2</td>"
                + "<td>Celda #3</td>"
                + "</tr>"
                + "</table>";
    }

    @RequestMapping(value = "/login", method = RequestMethod.GET)
    @ResponseBody
    public String recoverPass(@RequestParam("username") String username) {
        return "Welcome mr." + username;
    }

}
