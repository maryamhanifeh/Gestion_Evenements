package com.example.projet.service;
import com.example.projet.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;



import java.util.List;


@Service

public class UserServiceImpl extends UserService {
    @Autowired
    private UserRepository userRepository;

    public UserServiceImpl(com.example.projet.repository.UserRepository userRepository) {
        super(userRepository);
    }

    @Override
    public User getUserByUsername(String username) {
        return userRepository.findByUsername(username)
                .orElseThrow(() -> new UsernameNotFoundException("Utilisateur non trouvé avec le nom d'utilisateur : " + username));
    }
    @Override
    public User createUser(User user) {
        // Logique pour créer un utilisateur
        return userRepository.save(user);
    }

    @Override
    public User updateUser(User user) {
        // Vérifie si l'utilisateur existe
        if (userRepository.existsById(user.getId())) {
            // Logique pour mettre à jour un utilisateur
            return userRepository.save(user);
        } else {
            // Gérer le cas où l'utilisateur n'existe pas
            throw new UserNotFoundException("Utilisateur non trouvé avec l'ID : " + user.getId());
        }
    }

    @Override
    public void deleteUser(Long userId) {
        // Logique pour supprimer un utilisateur
        userRepository.deleteById(userId);
    }

    // ... autres méthodes

    @Override
    public User getUserById(Long userId) {
        // Logique pour récupérer un utilisateur par son identifiant
        return userRepository.findById(userId)
                .orElseThrow(() -> new UserNotFoundException("Utilisateur non trouvé avec l'ID : " + userId));
    }

    @Override
    public List<User> searchUsers(String keyword) {
        // Logique pour rechercher des utilisateurs par mot-clé
        return userRepository.findByUsernameContaining(keyword);
    }

    public class UserNotFoundException extends RuntimeException {
        public UserNotFoundException(String message) {
            super(message);
        }
    }

}