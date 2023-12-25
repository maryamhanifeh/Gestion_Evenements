package com.example.projet.model;
import jakarta.persistence.*;

import java.time.LocalDateTime;
@Entity
@Table(name = "Event")
public class Event {
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Long id;
    @Column(length = 64, nullable = false)
        private String title;
    @Column(length = 128, nullable = false, unique = true)
        private LocalDateTime startDateTime;
    @Column(length = 128, nullable = false, unique = true)
        private LocalDateTime endDateTime;
    @Column(length = 64, nullable = false)
        private String location;
    @Column(length = 64, nullable = false)
        private String Commentaire;

        @ManyToOne
        @JoinColumn(name = "user_id")
        private User owner;  // به جای user از عنوان بهتر owner استفاده شد.
       @ManyToOne
        @JoinColumn(name = "entrepreneur_id") // Use the correct column name
       private Entrepreneur entrepreneur;


        // Constructors
        public Event() {
            // سازنده پیشفرض
        }

        public Event(String title, LocalDateTime startDateTime, LocalDateTime endDateTime,
                     String location, String commentaire, User owner) {
            this.title = title;
            this.startDateTime = startDateTime;
            this.endDateTime = endDateTime;
            this.location = location;
            this.Commentaire = commentaire;
            this.owner = owner;
        }
        public Long getId() {
            return id;
        }
        public void setId(Long id) {
            this.id = id;
        }

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public LocalDateTime getStartDateTime() {
            return startDateTime;
        }

        public void setStartDateTime(LocalDateTime startDateTime) {
            this.startDateTime = startDateTime;
        }

        public LocalDateTime getEndDateTime() {
            return endDateTime;
        }

        public void setEndDateTime(LocalDateTime endDateTime) {
            this.endDateTime = endDateTime;
        }

        public String getLocation() {
            return location;
        }

        public void setLocation(String location) {
            this.location = location;
        }

        public String getCommentaire() {
            return Commentaire;
        }

        public void setCommentaire(String commentaire) {
            this.Commentaire = commentaire;
        }

        public User getOwner() {
            return owner;
        }

        public void setOwner(User owner) {
            this.owner = owner;
        }
    }
