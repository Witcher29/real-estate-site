package com.web_site.real_estate.controllers;

import com.web_site.real_estate.models.Complex;
import com.web_site.real_estate.models.Developer;
import com.web_site.real_estate.models.District;
import com.web_site.real_estate.models.Property;
import com.web_site.real_estate.repo.ComplexRepository;
import com.web_site.real_estate.repo.DeveloperRepository;
import com.web_site.real_estate.repo.DistrictRepository;
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

    @Autowired
    private DistrictRepository districtRepository;

    @Autowired
    private DeveloperRepository developerRepository;

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

    @GetMapping("/complex/{complex_name}")
    public String moreDetailsOfComplexes(@PathVariable("complex_name") String name, Model model) {
        String complexName = name.replace("-", " ");
        List<Complex> complexList = complexRepository.findAllByComplexName(complexName);
        if (!complexList.isEmpty()) {
            model.addAttribute("complex", complexList.get(0));
            return "complexPage";
        }
        return "homePage";
    }

    @GetMapping("/district/page/{numberOfPage}")
    public String districts(@PathVariable(required = false) Integer numberOfPage, Model model) {
        List<District> districts = districtRepository.findAll();
        model.addAttribute("districts", districts);
        if(numberOfPage != null)
            model.addAttribute("number", numberOfPage);
        return "all_districts";
    }

    @GetMapping("/district/{district_name}")
    public String moreDetailsOfDistricts(@PathVariable("district_name") String name, Model model) {
        String districtName = name.replace("-", " ");
        List<District> districtList = districtRepository.findAllByName(districtName);
        if (!districtList.isEmpty()) {
            model.addAttribute("district", districtList.get(0));
            return "districtPage";
        }
        return "homePage";
    }

    @GetMapping("/organisation/page/{numberOfPage}")
    public String dievelopers(@PathVariable(required = false) Integer numberOfPage, Model model) {
        List<Developer> developers = developerRepository.findAll();
        model.addAttribute("dievelopers", developers);
        if(numberOfPage != null)
            model.addAttribute("number", numberOfPage);
        return "all_developers";
    }
}