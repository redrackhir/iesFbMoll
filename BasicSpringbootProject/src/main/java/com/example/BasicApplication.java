package com.example;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
//@Controller
//@EnableAutoConfiguration
public class BasicApplication {

//    @RequestMapping("/")
//    @ResponseBody
//    String home() {
//        return "Hello World!";
//    }

    public static void main(String[] args) {
        SpringApplication.run(BasicApplication.class, args);
    }
}
