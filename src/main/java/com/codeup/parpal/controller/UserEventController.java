package com.codeup.parpal.controller;


import com.codeup.parpal.models.Event;
import com.codeup.parpal.models.User;
import com.codeup.parpal.models.UserEvent;
import com.codeup.parpal.repositories.EventsRepository;
import com.codeup.parpal.repositories.EventsUserRepository;
import com.codeup.parpal.repositories.UserRepository;
import com.codeup.parpal.services.EventsUserDaoService;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class UserEventController {

    @Autowired
    private EventsUserRepository eventsUserRepository;

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private EventsRepository eventsRepository;
@Autowired
    private EventsUserDaoService eventsUserDaoService;
    @PostMapping("/userEvents/{eventId}/add")
    public String addUserEvent(@RequestParam("eventId") Long eventId) {
        UserEvent userEvent = new UserEvent();
        eventsRepository.getEventById(eventId);
        User loggedInUser = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        userEvent.setAttendee(loggedInUser);
        userEvent.setEvent(eventsRepository.getEventById(eventId));
        eventsUserRepository.save(userEvent);

        return "redirect:/userEvents";
    }
    @GetMapping("/userEvents")
    public String showUserEvents(Model model){
        List<UserEvent> userEvents = eventsUserDaoService.findAll();
        model.addAttribute("allUserEvents", userEvents);
        return "events/myEvents";
    }
@PostMapping("/userEvents/{eventId}/remove")
    public String removeUserEventById(@PathVariable Long eventId){
        eventsUserDaoService.removeUserEventById(eventId);
        return "redirect:/userEvents";
}
}

// POST MAPPING
// Take in the Event ID from the form submission (RequestParam = "eventId")
    // Use the event repo to fetch event by id
    // Then create new UserEvent, with loggedInUser and Event ID

