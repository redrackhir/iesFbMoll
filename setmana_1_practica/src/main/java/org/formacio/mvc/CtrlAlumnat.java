/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.formacio.mvc;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 *
 * @author soib1a20
 */
@Controller
public class CtrlAlumnat {
    
    @RequestMapping("/")
    @ResponseBody
    public String index() {
        return "Nº de alumnos";
    }
    
    
    
}
