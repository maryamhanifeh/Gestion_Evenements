package com.example.projet.repository;
import com.example.projet.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    User findByUsername(String username);

    List<User> findByFullNameContaining(String keyword);

    User findByUsernameAndPassword(String username, String password);
    // Optional<User> findByUsername(String username);


}