package com.codeup.parpal.models;

import jakarta.persistence.*;

@Entity
@Table(name= "user_events")
public class UserEvent {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;


    @ManyToOne
    @JoinColumn (name = "user_id")
    private User attendee;

    @ManyToOne
    @JoinColumn(name= "event_id")
    private Event event;

    public UserEvent() {
    }

    public UserEvent(User attendee, Event event) {
        this.attendee = attendee;
        this.event = event;
    }

    public UserEvent(UserEvent copy) {
        id = copy.id;
        attendee = copy.attendee;
        event = copy.event;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public User getAttendee() {
        return attendee;
    }

    public void setAttendee(User attendee) {
        this.attendee = attendee;
    }

    public Event getEvent() {
        return event;
    }

    public void setEvent(Event event) {
        this.event = event;
    }
}