package com.example.projet.service;

import com.example.projet.model.Event;
import com.example.projet.repository.EventRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EventService {
    private final EventRepository eventRepository;

    public EventService(EventRepository eventRepository) {
        this.eventRepository = eventRepository;
    }
    public EventDTO createEvent(Event eventDTO) {
        // Logique métier pour créer un événement
        Event event = new Event();
        event.setTitle(eventDTO.getTitle());
        event.setDate(eventDTO.getDate());
        event.setStartTime(eventDTO.getStartTime());
        event.setEndTime(eventDTO.getEndTime());
        event.setLocation(eventDTO.getLocation());
        event.setComment(eventDTO.getComment());
        // Vous pouvez ajouter d'autres champs ici en fonction de votre modèle de données

        // Sauvegarder l'événement dans la base de données
        eventRepository.save(event);
        return eventDTO;
    }
    public EventDTO getEventById(Long eventId) {
        // Logique métier pour obtenir un événement par son ID
        Optional<Event> optionalEvent = eventRepository.findById(eventId);

        if (optionalEvent.isPresent()) {
            Event event = optionalEvent.get();
            EventDTO eventDTO = new EventDTO();
            eventDTO.setId(event.getId());
            eventDTO.setTitle(event.getTitle());
            eventDTO.setDate(event.getDate());
            eventDTO.setStartTime(event.getStartTime());
            eventDTO.setEndTime(event.getEndTime());
            eventDTO.setLocation(event.getLocation());
            eventDTO.setComment(event.getComment());
            // Ajoutez d'autres champs si nécessaire
            return eventDTO;
        } else {
            // Gérer le cas où l'événement n'est pas trouvé
            throw new EntityNotFoundException("Event with ID " + eventId + " not found");
        }
    }
    public List<Event> getAllEvents() {
        return null;
    }
}
