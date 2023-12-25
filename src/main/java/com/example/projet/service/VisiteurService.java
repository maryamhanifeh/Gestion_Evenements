package com.example.projet.service;

import com.example.projet.model.User;
import com.example.projet.model.Visiteur;
import com.example.projet.repository.EventRepository;
import com.example.projet.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service

public class VisiteurService {
    @Autowired
    private UserRepository utilisateurRepository;

    @Autowired
    private EventRepository eventRepository;

    // Méthode pour inscrire un visiteur
  //  public User inscrireVisiteur(Visiteur visiteur) {

        // Enregistrez le visiteur en base de données
   //     return utilisateurRepository.save(visiteur);
  //  }
    public User connecterVisiteur(String username, String password) {
        return utilisateurRepository.findByUsernameAndPassword(username, password).orElse(null);
    }

}
