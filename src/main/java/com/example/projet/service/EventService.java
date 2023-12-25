package com.example.projet.service;

import com.example.projet.model.Event;
import com.example.projet.repository.EventRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class EventService {

    private final EventRepository eventRepository;

    public EventService(EventRepository eventRepository) {
        this.eventRepository = eventRepository;
    }

    public Event createEvent(Event event) {
        return eventRepository.save(event);
    }

    public Event getEventById(Long eventId) {
        Optional<Event> optionalEvent = eventRepository.findById(eventId);

        if (optionalEvent.isPresent()) {
            return optionalEvent.get();
        } else {
            throw new EntityNotFoundException("Event with ID " + eventId + " not found");
        }
    }

    public List<Event> getAllEvents() {
        return eventRepository.findAll();
    }

    public Event updateEvent(Long eventId, Event updatedEvent) {
        // Implement logic to update event
        return eventRepository.save(updatedEvent);
    }

    public void deleteEvent(Long eventId) {
        // Implement logic to delete event
        eventRepository.deleteById(eventId);
    }
}
