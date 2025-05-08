package com.codeup.parpal.models;

import jakarta.persistence.*;
import org.springframework.web.bind.annotation.ModelAttribute;


import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name= "events")
public class Event {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;


    @Column(nullable = false, length = 100)
    private String title;

    @Column(nullable = false)
    private LocalDateTime date_time_start;

    @Column(nullable = false)
    private LocalDateTime date_time_end;

    @Column(nullable = false)
    private String description;

    @Column(nullable = false)
    private String course;

    @Column(nullable = false)
    private boolean is_18;



    @OneToMany(cascade = CascadeType.ALL, mappedBy = "event")
    private List<UserEvent> events;
    public Event() {
    }
    @ManyToOne
    @JoinColumn(name= "host_id")
    private User host;


    public Event(String title, LocalDateTime date_time_start, LocalDateTime date_time_end, String description, String course, boolean is_18) {
        this.title = title;
        this.date_time_start = date_time_start;
        this.date_time_end = date_time_end;
        this.description = description;
        this.course = course;
        this.is_18 = is_18;
    }

    public List<UserEvent> getEvents() {
        return events;
    }
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public LocalDateTime getDate_time_start() {
        return date_time_start;
    }

    public void setDate_time_start(LocalDateTime date_time_start) {
        this.date_time_start = date_time_start;
    }

    public LocalDateTime getDate_time_end() {
        return date_time_end;
    }

    public void setDate_time_end(LocalDateTime date_time_end) {
        this.date_time_end = date_time_end;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getCourse() {
        return course;
    }

    public void setCourse(String course) {
        this.course = course;
    }

    public boolean getIs_18() {
        return is_18;
    }

    public void setIs_18(boolean is_18) {
        this.is_18 = is_18;
    }

    public boolean isIs_18() {
        return is_18;
    }

    public void setEvents(List<UserEvent> events) {
        this.events = events;
    }

    public User getHost() {
        return host;
    }

    public void setHost(User host) {
        this.host = host;
    }

    public void setUser(org.springframework.security.core.userdetails.User loggedInUser) {
    }


    @Override
    public String toString() {
        return "Event{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", date_time_start=" + date_time_start +
                ", date_time_end=" + date_time_end +
                ", description='" + description + '\'' +
                ", course='" + course + '\'' +
                ", is_18=" + is_18 +
                ", events=" + events +
                ", host=" + host +
                '}';
    }
}

