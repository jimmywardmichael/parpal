package com.codeup.parpal.controller;


import com.codeup.parpal.models.Event;
import com.codeup.parpal.models.User;
import com.codeup.parpal.services.EventsDaoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;


import java.util.List;


@Controller
public class EventsController {
    @Autowired
    private final EventsDaoService eventDao;


    public EventsController(EventsDaoService eventDao) {
        this.eventDao = eventDao;

    }

    @GetMapping("/events/index")
    public String showMyEvents(Model model) {
        List<Event> myEvents = eventDao.getAllEvents();
        model.addAttribute("allEvents", myEvents);
        return "events/index";
    }


    // Showing all events from eventDaoService
    @GetMapping("/events/user-home")
    public String showEvents(Model model){
        List<Event> events = eventDao.findAll();
        model.addAttribute("allEvents", events);
        return "events/user-home";
    }

    //Search for single event
    @GetMapping("/events/{id}")
    public String singleEvent(@PathVariable long id, Model model){
        User loggedInUser = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        model.addAttribute("event", eventDao.getEventById(id));
        return "events/index";
    }
    //CREATE a new event
    @GetMapping("/events/create-event")
    public String eventCreateForm(Model model){
        model.addAttribute("event", new Event());
        return "events/create-event";
    }
    //Display and READ created Event and save
    @PostMapping(path = "/events/create-event")
    public String eventCreateSubmit(@ModelAttribute Event event){
        eventDao.saveEvent(event);
        return "redirect:/events/index";
    }

    //Edit Event
    @GetMapping("/events/{id}/edit")
    public String showEditForm(@PathVariable Long id, Model model) {
        Event event = eventDao.getEventById(id);
        model.addAttribute("event", event);
        return "events/edit";
    }

    @PostMapping("/events/{id}/edit")
    public String updateEvent(@ModelAttribute Event event) {
        eventDao.saveEvent(event);
        return "redirect:/events/index";
    }

    //Delete Event
    @PostMapping("/deleteEvent/{eventId}")
    public String deleteEvent(@PathVariable Long eventId) {
        eventDao.deleteEventById(eventId);
        return "redirect:/events/index";
    }
}