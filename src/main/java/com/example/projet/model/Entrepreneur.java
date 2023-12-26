package com.example.projet.model;
import jakarta.persistence.*;
import java.util.List;

    @Entity
    @Table(name = "entrepreneur")

    public class Entrepreneur {

        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Long id;
        @Column(length = 128, nullable = false, unique = true)
        private String name;
        @Column(length = 128, nullable = false, unique = true)
        private String prenom;

        @OneToMany(mappedBy = "entrepreneur") // Make sure "entrepreneur" is a valid property in the Event class
        private List<Event> events;


        public Entrepreneur() {
        }

        public Long getId() {
            return id;
        }

        public String getName() {
            return name;
        }

        public String getPrenom() {
            return prenom;
        }

        public List<Event> getEvents() {
            return events;
        }

        public void setId(Long id) {
            this.id = id;
        }

        public void setName(String name) {
            this.name = name;
        }

        public void setPrenom(String prenom) {
            this.prenom = prenom;
        }

        public void setEvents(List<Event> events) {
            this.events = events;
        }
    }

