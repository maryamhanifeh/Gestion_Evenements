package com.example.projet.model;
import jakarta.persistence.*;

import java.time.LocalDateTime;
@Entity
@Table(name = "Event")
public class Event {
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Long id;

        private String title;
        private LocalDateTime startDateTime;
        private LocalDateTime endDateTime;
        private String location;
        private String commentaire;

        @ManyToOne
        @JoinColumn(name = "user_id")
        private User owner;  // به جای user از عنوان بهتر owner استفاده شد.

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
            this.commentaire = commentaire;
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
            return commentaire;
        }

        public void setCommentaire(String commentaire) {
            this.commentaire = commentaire;
        }

        public User getOwner() {
            return owner;
        }

        public void setOwner(User owner) {
            this.owner = owner;
        }
    }
