package com.web_site.real_estate.controllers;

import com.web_site.real_estate.models.Property;
import com.web_site.real_estate.repo.PropertyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;
import java.util.Optional;

@Controller
public class MainController {

    @Autowired
    private PropertyRepository propertyRepository;

    @GetMapping("/")
    public String home(Model model) {
        List<Property> properties = propertyRepository.findAll();

        model.addAttribute("properties", properties);

        return "homePage";
    }

    @GetMapping("/property/{bedrooms}-bedrooms-in-{complexName}-{id}")
    public String moreDetailsOfProperties(@PathVariable("id") Integer idOfProperty, Model model) {
        Optional<Property> propertyOptional = propertyRepository.findById(idOfProperty);
        if (propertyOptional.isPresent()) {
            Property property = propertyOptional.get();
            model.addAttribute("property", property);
        }
        return "propertyPage";
    }
}