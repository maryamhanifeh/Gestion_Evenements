package com.example.projet.repository;

import com.example.projet.model.Entrepreneur;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
@Repository

public interface EntrepreneurRepository extends JpaRepository<Entrepreneur, Long> {
    List<Entrepreneur> findAll();

    Optional<Entrepreneur> findById(Long entrepreneurId);

    Entrepreneur save(Entrepreneur entrepreneur);

    void deleteById(Long entrepreneurId);
}
