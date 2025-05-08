package com.codeup.parpal.controller;


import com.codeup.parpal.models.User;
import com.codeup.parpal.repositories.PalsRepository;
import com.codeup.parpal.repositories.UserRepository;
import com.codeup.parpal.services.PalsDaoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import com.codeup.parpal.models.Pals;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class PalsController {

    private final PalsDaoService palDao;
    private final PalsRepository palsRepository;

    private final UserRepository userRepository;

    public PalsController(PalsDaoService palDao, PalsRepository palsRepository, UserRepository userRepository) {
        this.palDao = palDao;
        this.palsRepository = palsRepository;
        this.userRepository = userRepository;
    }

    @GetMapping("/pals")
    public String showPals(Model model){
        List<Pals> pals = palDao.findAll();
        model.addAttribute("allPals", pals);
        return "pals/index";
    }

    @PostMapping("/pals/{palId}/remove")
    public String removePal(@PathVariable long palId) {
        palDao.removePalById(palId);
        return "redirect:/pals";
    }

    @PostMapping("/pals/{palId}/add")
    public String addPal(@PathVariable Long palId){
        Pals pal = new Pals();
        System.out.println(pal.getId());
        pal.setPal(userRepository.findById(palId).get());
        palDao.addPal(pal);
        return "redirect:/pals";
    }

}
