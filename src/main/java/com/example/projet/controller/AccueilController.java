package com.example.projet.controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class AccueilController {
    @GetMapping("/")
    public String showAccueil() {
        return "home";
    }

    @GetMapping("/contact")
    public String showContactForm(){return "contactez-nous";}

    @GetMapping("/inscription")
    public String showInscriptionForm(){return "inscription";}
}