package com.codeup.parpal.services;

import com.codeup.parpal.models.Event;
import com.codeup.parpal.models.User;
import com.codeup.parpal.repositories.EventsRepository;
import com.codeup.parpal.repositories.UserRepository;
import org.springframework.security.core.context.SecurityContextHolder;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EventsDaoService {
    private final EventsRepository eventsRepository;
    private  final UserRepository userRepository;



    public EventsDaoService(EventsRepository eventsRepository, UserRepository userRepository){
        this.eventsRepository = eventsRepository;
        this.userRepository = userRepository;
    }
    //Create and save event
    public void saveEvent(Event event){
        User loggedInUser = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        System.out.println(loggedInUser);
        event.setHost(loggedInUser);

        eventsRepository.save(event);
    }
    //Read all events for current logged in user
    public List<Event> getAllEvents() {
        // Get the currently logged-in user
        User loggedInUser = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();

        // Return only the events created by the logged-in user
        return eventsRepository.findByHost(loggedInUser);
    }
    //    public List<Event> getAllEvents(){
//        return eventsRepository.findAll();
//    }
    public Event getEventById(long id) {
        if (eventsRepository.findById(id).isPresent()) {
            return eventsRepository.findById(id).get();
        } else {
            throw new RuntimeException("Event was not found.");
        }
    }
//Edit

    //Delete
    public void deleteEventById(Long eventId) {
        eventsRepository.deleteById(eventId);
    }


    public List<Event> findAll() {
        return  eventsRepository.findAll();
    }

    public void updateEvent(Event event) {
        eventsRepository.save(event);
    }

    public List<Event> findEventsByHostId(long id) {
        return eventsRepository.getEventsByHostId(id);
    }
    }



