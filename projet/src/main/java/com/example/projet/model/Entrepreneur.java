package com.example.projet.model;

import jakarta.persistence.*;
import java.util.List;

    @Entity
    @Table(name = "entrepreneurs")
    public class Entrepreneur {

            @Id
            @GeneratedValue(strategy = GenerationType.IDENTITY)
            private Long id;
            private String name;
            private String prenom;

            @OneToMany(mappedBy = "entrepreneur")
            private List<Event> events;

            // Constructor
            public Entrepreneur() {
            }


            public Long getId() {
                return id;
            }

            public String getName() {
                return name;
            }
        public String getPrenom() {
            return prenom ;
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
        public void setPrenom(String Prenom) {
            this.Prenom = Prenom;
        }
            public void setEvents(List<Event> events) {
                this.events = events;
            }

    }

