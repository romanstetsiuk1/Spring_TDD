package com.romanstetsiuk.spring_tdd.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class SecurityController {

    @GetMapping("/prywatna")
    String priv(){

        return "private";
    }

}
