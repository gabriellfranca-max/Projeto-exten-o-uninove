package com.sistema.sistema_tarefas.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class LoginController {

    @GetMapping("/login")
    public String login() {
        return "login"; // carrega login.html
    }

    @GetMapping("/home")
    public String home() {
        return "home"; // carrega home.html
    }
}
