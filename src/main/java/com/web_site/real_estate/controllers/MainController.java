package com.web_site.real_estate.controllers;

import com.web_site.real_estate.models.Complex;
import com.web_site.real_estate.models.Property;
import com.web_site.real_estate.repo.ComplexRepository;
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

    @Autowired
    private ComplexRepository complexRepository;

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

    @GetMapping("/complex/page/{numberOfPage}")
    public String complexes(@PathVariable(required = false) Integer numberOfPage, Model model) {
        List<Complex> complexes = complexRepository.findAll();

        model.addAttribute("complexes", complexes);
        if(numberOfPage != null)
            model.addAttribute("number", numberOfPage);
        return "all_complexes";
    }

    @GetMapping("/complex/{complex_name}-{id}")
    public String moreDetailsOfComplexes(@PathVariable("id") Integer idOfComplex, Model model) {
        Optional<Complex> complexOptional = complexRepository.findById(idOfComplex);
        if (complexOptional.isPresent()) {
            Complex complex = complexOptional.get();
            model.addAttribute("complex", complex);
        }
        return "complexPage";
    }

    @GetMapping("/district/page/{numberOfPage}")
    public String districts(@PathVariable(required = false) Integer numberOfPage, Model model) {
        List<Complex> complexes = complexRepository.findAll();

        model.addAttribute("complexes", complexes);
        if(numberOfPage != null)
            model.addAttribute("number", numberOfPage);
        return "all_complexes";
    }
}