package com.codeup.parpal.models;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name= "user_events")
public class User_Events {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;


    @ManyToOne
    @JoinColumn (name = "event_id")
    private Event events;


}

