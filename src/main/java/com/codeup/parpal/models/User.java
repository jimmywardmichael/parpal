package com.codeup.parpal.models;

import com.codeup.parpal.repositories.UserRepository;
import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name= "users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(nullable = false, length = 50, unique = true)
    private String username;

    @Column(nullable = false, length = 50)
    private String name;

    @Column(nullable = false)
    public boolean is_18;
    @Column(nullable = false, unique = true)
    private String email;
    @Column(nullable = false)
    private String password;
    @Column(nullable = false)
    private boolean is_org;
    @Column
    private Integer handicap;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "attendee")
    private List<UserEvent> events;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "host")
    private List<Event> hosted_events;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "me")
    private List<Pals> pals;

    public boolean isIs_org() {
        return is_org;
    }

    public Integer getHandicap() {
        return handicap;
    }

    public boolean isIs_18() {
        return is_18;
    }

    public void setHandicap(Integer handicap) {
        this.handicap = handicap;
    }

    public List<Event> getHosted_events() {
        return hosted_events;
    }

    public void setHosted_events(List<Event> hosted_events) {
        this.hosted_events = hosted_events;
    }

    public List<UserEvent> getEvents() {
        return events;
    }

    public List<Pals> getPals() {
        return pals;
    }

    public void setPals(List<Pals> pals) {
        this.pals = pals;
    }

    public User(String username, String name, boolean is_18, String email, String password, boolean is_org, Integer handicap, List<UserEvent> events, List<Event> hosted_events, List<Pals> pals) {
        this.username = username;
        this.name = name;
        this.is_18 = is_18;
        this.email = email;
        this.password = password;
        this.is_org = is_org;
        this.handicap = handicap;
        this.events = events;
        this.hosted_events = hosted_events;
        this.pals = pals;
    }

    public void setEvents(List<UserEvent> events) {
        this.events = events;
    }

    public User() {
    }

    public User(User copy) {
        id = copy.id;
        email = copy.email;
        username = copy.username;
        password = copy.password;
        name = copy.name;
        is_org = copy.is_org;
        is_18 = copy.is_18;
        handicap = copy.handicap;
    }

    public User(String username, String name, boolean is_18, String email, String password, boolean is_org, Integer handicap) {
        this.username = username;
        this.name = name;
        this.is_18 = is_18;
        this.email = email;
        this.password = password;
        this.is_org = is_org;
        this.handicap = handicap;
    }

    public User(String username, String name, boolean is_18, String email, String password, boolean is_org, List<UserEvent> events, List<Event> hosted_events) {
        this.username = username;
        this.name = name;
        this.is_18 = is_18;
        this.email = email;
        this.password = password;
        this.is_org = is_org;
        this.events = events;
        this.hosted_events = hosted_events;
    }

    public User(String username, String name, Boolean is_18, String email, Boolean is_org, Integer handicap) {
        this.username = username;
        this.name = name;
        this.is_18 = is_18;
        this.email = email;
        this.is_org = is_org;
        this.handicap = handicap;
    }


    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean getIs_18() {
        return is_18;
    }

    public void setIs_18(boolean is_18) {
        this.is_18 = is_18;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }


    public boolean getIs_org() {
        return is_org;
    }

    public void setIs_org(boolean is_org) {
        this.is_org = is_org;
    }

}