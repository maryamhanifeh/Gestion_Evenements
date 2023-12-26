package com.example.projet.model;

import jakarta.persistence.*;
import org.springframework.http.ResponseEntity;

import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

@Entity
@Table(name = "User")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(length = 64, nullable = false)
    private String username;
    @Column(length = 128, nullable = false, unique = true)
    private String password;
    @Column(length = 64, nullable = false)
    private String nom;
    @Column(length = 64, nullable = false)
    private String prenom;

    @Column(length = 64)
    private String photo;


    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public Set<Role> getRoles() {
        return roles;
    }

    public void setRoles(Set<Role> roles) {
        this.roles = roles;
    }


    public String getPhoto() {
        return photo;
    }

    @ManyToMany
    @JoinTable(
            name="user_role",
            joinColumns = @JoinColumn(name="user_id"),
            inverseJoinColumns = @JoinColumn(name="role_id")
    )
    private Set<Role> roles = new HashSet();
    public void setPhoto(String photo) {
        this.photo = photo;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    private boolean active;
    @OneToMany(mappedBy = "owner")
    private List<Event> events;

    public User(Long id, String username, String password, String nom, String prenom) {
        this.id= id;
        this.username = username;
        this.password = password;
        this.nom  = nom;
        this.prenom = prenom;
    }
    public User() {
    }
    @ManyToMany
    @JoinTable(
            name = "user_friends",
            joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "friend_id")
    )
    private List<User> friends;
    public boolean isFriend(User otherUser) {
        return friends.contains(otherUser);
    }
    public String getUsername() {
        return username;
    }
    public void setUsername(String username) {
    this.username = username;
    }

    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
    }

    public List<Event> getEvents() {
        return events;
    }
    public void setEvents(List<Event> events) {
        this.events = events;
    }
    public List<User> getFriends() {
        return friends;
    }

    public void setFriends(List<User> friends) {
        this.friends = friends;
    }

    public void setId(Long id) {
        this.id = id;
    }
    public Long getId() {
        return id;
    }

 //   public User orElse(User otherUser) {
   //     EntrepreneurRepository entrepreneurRepository;
    //    return entrepreneurRepository.findById(otherUser.getId()).orElse(otherUser);
   // }
   //public User orElseThrow() {
     //   EntrepreneurRepository userRepository;
     //   return userRepository.findById(this.getId())
       //         .orElseThrow(() -> new RuntimeException("User not found with id: " + this.getId()));
 //   }

    public Optional<ResponseEntity<Object>> map(Object o) {
        // توجه: این متد بیشتر برای DTO یا تبدیل اطلاعات به شکل مورد نیاز در جریان اجرا استفاده می‌شود.
        return Optional.ofNullable(ResponseEntity.ok().build());
    }

    public User orElse(Object o) {
        User o1 = null;
        return o1;
    }
}

   

    