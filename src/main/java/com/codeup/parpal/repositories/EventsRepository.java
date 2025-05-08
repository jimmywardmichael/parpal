package com.codeup.parpal.repositories;



import com.codeup.parpal.models.Event;
import com.codeup.parpal.models.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface EventsRepository extends JpaRepository<Event, Long> {



    Event getEventById(long id);


    void deleteEventById(long id);
    //Added to find event for current user logged in to show only their events created
    List<Event> findByHost(User loggedInUser);
    List<Event> getEventsByHostId(long id);


}
