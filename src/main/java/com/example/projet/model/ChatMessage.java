package com.example.projet.model;

import jakarta.persistence.*;

import java.util.Date;

@Entity
@Table(name="chatmessage")

public class ChatMessage {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idChat;

    @Column(name = "message", length = 255)
    private String message;

    @Column(name = "dateMessage")
    private Date dateMessage;

    @ManyToOne
    @JoinColumn(name = "idUtilisateur")
    private User utilisateur;
}