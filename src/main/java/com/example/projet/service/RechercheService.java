package com.example.projet.service;

import com.example.projet.model.Event;
import com.example.projet.model.User;
import com.example.projet.repository.EventRepository;
import com.example.projet.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RechercheService {
    private final EventRepository eventRepository;
    private final UserRepository userRepository;
    @Autowired
    public RechercheService(EventRepository eventRepository, UserRepository userRepository) {
        this.eventRepository = eventRepository;
        this.userRepository = userRepository;
    }

    public List<Event> searchEvents(String keyword) {
        //  جستجو بر اساس عنوان رویداد
        return eventRepository.findByTitleContaining(keyword);
    }

    public List<User> searchUsers(String keyword) {
        //  جستجو بر اساس نام کاربر
        return userRepository.findByFullNameContaining(keyword);
    }
}
