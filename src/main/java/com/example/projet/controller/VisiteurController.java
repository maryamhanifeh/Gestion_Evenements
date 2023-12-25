package com.example.projet.controller;

import com.example.projet.service.VisiteurService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/visiteurs")
public class VisiteurController {

    @Autowired
    private VisiteurService visiteurService;



}
