package com.example.projet.repository;
import com.example.projet.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    User findByUsername(String username);

//    List<User> findByFirstNameContainingOrLastNameContaining();


    User findByUsernameAndPassword(String username, String password);

//    List<User> findByFirstNameContainingOrLastNameContaining(String firstName, String lastName);
//    // Optional<User> findByUsername(String username);
List<User> findByUsernameContaining(String keyword);


}