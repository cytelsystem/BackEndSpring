package com.paciente.controller;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@Controller
public class PacienteController {
    @GetMapping("/")
    public String welcome(Model model) {
        model.addAttribute("nombre", "Oscar");
        model.addAttribute("apellido", "Artuaga");

        model.addAttribute("ProstataFuncionando", "20%");
        model.addAttribute("ProstataFallando", "80%");
        model.addAttribute("CorazonFuncionando", "70%");
        model.addAttribute("CorazonFallando", "30%");
        model.addAttribute("ColonFuncionando", "50%");
        model.addAttribute("ColonFallando", "50%");
        return "index";
    }
}

