package com.codeup.parpal.controller;

import org.apache.tomcat.util.modeler.BaseAttributeFilter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {
    @Value("${MAPBOX_API_KEY}")


    private String mapboxKey;

    @GetMapping("/")
    public String welcome(Model model) {
        model.addAttribute("mapBoxKey", mapboxKey);
        return "home";
    }

}

