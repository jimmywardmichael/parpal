package com.codeup.parpal.services;

import com.codeup.parpal.models.Event;
import com.codeup.parpal.models.User;
import com.codeup.parpal.models.UserEvent;
import com.codeup.parpal.repositories.EventsRepository;
import com.codeup.parpal.repositories.EventsUserRepository;
import com.codeup.parpal.repositories.UserRepository;
import org.springframework.stereotype.Service;
import org.springframework.security.core.context.SecurityContextHolder;

import java.util.List;

@Service
public class EventsUserDaoService {
    private EventsUserRepository eventsUserRepository;
    private EventsRepository eventsRepository;
    private UserRepository userRepository;

    public EventsUserDaoService(EventsUserRepository eventsUserRepository, EventsRepository eventsRepository, UserRepository userRepository) {
        this.eventsUserRepository = eventsUserRepository;
        this.eventsRepository = eventsRepository;
        this.userRepository = userRepository;
    }

    public Event getEventById(long id){
        if(eventsUserRepository.findById(id).isPresent()){
            return eventsRepository.findById(id).get();
        }else{
            throw new RuntimeException("Event not found");
        }
    }
    public void addUserEvent(UserEvent userEvent){
        User loggedInUser = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        userEvent.setAttendee(loggedInUser);
        eventsUserRepository.save(userEvent);
    }

    public List<UserEvent> findAll(){
        return eventsUserRepository.findAll();
    }

    public void removeUserEventById(Long userEventId){
        eventsUserRepository.deleteById(userEventId);
    }
}
