package com.example.projet.service;
import com.example.projet.model.Entrepreneur;
import com.example.projet.repository.EntrepreneurRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service

public class EntrepreneurService {
    private final EntrepreneurRepository entrepreneurRepository;

    @Autowired
    public EntrepreneurService(EntrepreneurRepository entrepreneurRepository) {
        this.entrepreneurRepository = entrepreneurRepository;
    }

    public List<Entrepreneur> getAllEntrepreneurs() {
        return entrepreneurRepository.findAll();
    }

    public Optional<Entrepreneur> getEntrepreneurById(Long entrepreneurId) {
        return entrepreneurRepository.findById(entrepreneurId);
    }

    public Entrepreneur createEntrepreneur(Entrepreneur entrepreneur) {
        return entrepreneurRepository.save(entrepreneur);
    }

    public void deleteEntrepreneur(Long entrepreneurId) {
        entrepreneurRepository.deleteById(entrepreneurId);
    }

}
