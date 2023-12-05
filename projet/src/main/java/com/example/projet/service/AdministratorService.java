package com.example.projet.service;


import org.springframework.beans.factory.annotation.Autowired;

public class AdministratorService {
    private final AdministratorRepository administratorRepository;

    @Autowired
    public AdministratorService(AdministratorRepository administratorRepository) {
        this.administratorRepository = administratorRepository;
    }

    public List<Administrator> getAllAdministrators() {
        return administratorRepository.findAll();
    }

    public Optional<Administrator> getAdministratorById(Long administratorId) {
        return administratorRepository.findById(administratorId);
    }

    public Administrator createAdministrator(Administrator administrator) {
        return administratorRepository.save(administrator);
    }

    public void deleteAdministrator(Long administratorId) {
        administratorRepository.deleteById(administratorId);
    }

    // اضافه کردن متدهای دیگر به متغیر administratorRepository بستگی دارد
}

