package com.codeup.parpal.repositories;


import com.codeup.parpal.models.UserEvent;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EventsUserRepository extends JpaRepository<UserEvent, Long> {

}
