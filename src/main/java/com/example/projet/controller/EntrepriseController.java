package com.example.projet.controller;

import com.example.projet.model.Event;
import com.example.projet.service.EntrepreneurService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/entreprise")
public class EntrepriseController {

    @Autowired
    public EntrepriseController(EntrepreneurService entrepreneurService) {
    }

    @GetMapping("/dashboard")
    public String getDashboard() {
        // Logique pour récupérer le tableau de bord de l'entreprise
        return "entreprise/dashboard"; // Nom de la vue à afficher (à personnaliser)
    }

    @GetMapping("/events")
    public String getAllEvents() {
        // Logique pour récupérer tous les événements de l'entreprise
        return "entreprise/events"; // Nom de la vue à afficher (à personnaliser)
    }

    @GetMapping("/events/{eventId}")
    public String getEventDetails(@PathVariable Long eventId) {
        // Logique pour récupérer les détails d'un événement par son ID
        return "entreprise/event-details"; // Nom de la vue à afficher (à personnaliser)
    }

    @GetMapping("/events/add")
    public String showAddEventForm() {
        // Logique pour afficher le formulaire d'ajout d'un événement
        return "entreprise/add-event"; // Nom de la vue à afficher (à personnaliser)
    }

    @PostMapping("/events/add")
    public String addEvent(@ModelAttribute Event event) {
        // Logique pour ajouter un nouvel événement
        return "redirect:/entreprise/events"; // Redirection après l'ajout (à personnaliser)
    }
}
