package com.example.projet.controller;

import com.example.projet.model.Event;
import com.example.projet.model.User;
import com.example.projet.service.RechercheService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class RechercheController {

    private final RechercheService rechercheService;

    public RechercheController(RechercheService rechercheService) {
        this.rechercheService = rechercheService;
    }

    @GetMapping("/recherche/events")
    public List<Event> searchEvents(@RequestParam String keyword) {
        // انجام جستجوی رویدادها بر اساس کلمه کلیدی
        return rechercheService.searchEvents(keyword);
    }

    @GetMapping("/recherche/users")
    public List<User> searchUsers(@RequestParam String keyword) {
        // انجام جستجوی کاربران بر اساس کلمه کلیدی
        return rechercheService.searchUsers(keyword);
    }
}
