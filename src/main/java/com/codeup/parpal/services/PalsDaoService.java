package com.codeup.parpal.services;

import com.codeup.parpal.models.Pals;
import com.codeup.parpal.models.User;
import com.codeup.parpal.repositories.PalsRepository;
import com.codeup.parpal.repositories.UserRepository;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class PalsDaoService {

    private PalsRepository palsRepository;

    private UserRepository userRepository;

    public PalsDaoService(PalsRepository palsRepository, UserRepository userRepository) {
        this.palsRepository = palsRepository;
        this.userRepository = userRepository;
    }

    public User getPalById(long palId) {
        if (userRepository.findById(palId).isPresent()) {
            return userRepository.findById(palId).get();
        } else {
            throw new RuntimeException("Post was not found.");
        }
    }

    public void addPal(Pals pal){
        User loggedInUser = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        pal.setMe(loggedInUser);
        palsRepository.save(pal);
    }

    public void removePalById(Long palId) {
        palsRepository.deleteById(palId);
    }


    public List<Pals> findAll() {
        return  palsRepository.findAll();
    }





}
