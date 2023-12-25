package com.example.projet.controller;

import com.example.projet.model.User;
import com.example.projet.service.AdministratorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/admin")
public class AdministratorController {

    private final AdministratorService administratorService;

    @Autowired
    public AdministratorController(AdministratorService administratorService) {
        this.administratorService = administratorService;
    }

    @GetMapping("/users")
    public String getAllUsers() {
        return "admin/users"; // Nom de la vue à afficher (à personnaliser)
    }

    @GetMapping("/users/{userId}")
    public String getUserDetails(@PathVariable Long userId) {
        return "admin/user-details"; // Nom de la vue à afficher (à personnaliser)
    }

    @PostMapping("/users/{userId}/delete")
    public String deleteUser(@PathVariable Long userId) {
        return "redirect:/admin/users"; // Redirection après la suppression (à personnaliser)
    }

    @GetMapping("/users/add")
    public String showAddUserForm() {
        return "admin/add-user"; // Nom de la vue à afficher (à personnaliser)
    }

    @PostMapping("/users/add")
    public String addUser(@ModelAttribute User user) {
        return "redirect:/admin/users"; // Redirection après l'ajout (à personnaliser)
    }
}
