package com.codeup.parpal.models;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name="pals")
public class Pals {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @ManyToOne
    @JoinColumn (name = "user_id")
    private User me;

    @ManyToOne
    @JoinColumn(name= "pal_id")
    private User pal;


    public Pals(User me) {
        this.me = me;
    }

    public Pals() {
    }



    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public User getMe() {
        return me;
    }

    public void setMe(User me) {
        this.me = me;
    }

//    public void setUser(User user) {
//    }


    public User getPal() {
        return pal;
    }

    public void setPal(User pal) {
        this.pal = pal;
    }

    public Pals(User me, User pal) {
        this.me = me;
        this.pal = pal;
    }

    public Pals(Pals copy) {
        id = copy.id;
        me = copy.me;
        pal = copy.pal;
    }


}
