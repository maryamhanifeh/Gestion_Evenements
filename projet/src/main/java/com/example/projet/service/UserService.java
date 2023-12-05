package com.example.projet.service;

import com.example.projet.repository.EventRepository;
import com.example.projet.repository.UserRepository;
import org.springframework.stereotype.Service;
import com.example.projet.model.User;
import java.util.List;
import java.util.Optional;


@Service
public abstract class UserService {
    private final UserRepository userRepository;


    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public List<User> getAllUsers() {

        return userRepository.findAll();
    }

    public Optional<User> getUserById(Long userId) {

        return userRepository.findById(userId);
    }

    public User createUser(User user) {
        return userRepository.save(user);
    }

    public abstract User updateUser(User user);

    public void deleteUser(Long userId) {

        userRepository.deleteById(userId);
    }

    public User getUserByUsername(String username) {
        return userRepository.findByUsername(username)
                .orElse(null);
    }

    public abstract List<User> searchUsers(String keyword);


    public static class EventService {
        private EventRepository eventRepository;
    }

    @Service
    public static class AbuseReportService {
        private AbuseReportRepository abuseReportRepository;

    }
    @Service
    public static class EntrepreneurService {
        private EntrepreneurRepository entrepreneurRepository;
    }


}