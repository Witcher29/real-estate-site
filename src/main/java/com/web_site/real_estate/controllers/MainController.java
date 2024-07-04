package com.web_site.real_estate.controllers;

import com.web_site.real_estate.models.Property;
import com.web_site.real_estate.repo.PropertyRepository;
import com.web_site.real_estate.services.MainService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;
import java.util.Map;

@Controller
public class MainController {

    @Autowired
    private PropertyRepository propertyRepository;

    @GetMapping("/")
    public String home(Model model) {
        List<Property> properties = propertyRepository.findAll();

        for (int i=1; i<properties.size() + 1; i++) {
            model.addAttribute("property" + i, properties.get(i-1));
        }

        return "homePage";
    }

    @Autowired
    MainService mainService;

    @GetMapping("/property/{s}")
    public String moreDetailsOfProperties(@PathVariable("s") String s, Model model) {

        List<Property> properties = propertyRepository.findAll();
        for (int i=1; i<properties.size() + 1; i++) {
            model.addAttribute("property" + i, properties.get(i-1));
        }

        Map<Integer, String> mapOfIdAndPath = mainService.makeNameOfPropertyReference();
        for (Map.Entry<Integer, String> entry : mapOfIdAndPath.entrySet()) {
            int key = entry.getKey();
            String value = entry.getValue();
            if (s.equals(value))
                return "property" + key;
        }
        return "homePage";
    }
}