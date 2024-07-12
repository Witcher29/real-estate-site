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

import java.util.*;

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

            List<Property> properties = propertyRepository.findAllByBedrooms(property.getBedrooms());
            Collections.shuffle(properties, new Random());
            properties = properties.subList(0, 6);
            model.addAttribute("properties", properties);
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

        List<Complex> complexesForShuffle = complexRepository.findAll();
        Collections.shuffle(complexesForShuffle, new Random());
        List<Complex> endList = new ArrayList<>();

        for (int i=0; i<complexesForShuffle.size(); i++) {
            if (!(complexesForShuffle.get(i).getComplex_name().equals(complexName)))
                endList.add(complexesForShuffle.get(i));
            if (endList.size() == 6)
                break;
        }
        List<Complex> complexList = complexRepository.findAllByComplexName(complexName);
        if (!complexList.isEmpty()) {
            model.addAttribute("complex", complexList.get(0));
            model.addAttribute("complexes", endList);
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

            List<Property> properties = new ArrayList<>();
            int i = 0;
            while (properties.size() < 6 && i <= districtList.get(0).getComplexList().size()-1) {
                properties.addAll(districtList.get(0).getComplexList().get(i).getPropertyList());
                i++;
            }
             if (properties.size() > 5)
                 properties = properties.subList(0, 6);
            model.addAttribute("properties", properties);

            return "districtPage";
        }
        return "homePage";
    }

    @GetMapping("/organisation/page/{numberOfPage}")
    public String developers(@PathVariable Integer numberOfPage, Model model) {
        List<Developer> developers = developerRepository.findAll();
        model.addAttribute("developers", developers);
        if(numberOfPage != null)
            model.addAttribute("number", numberOfPage);
        return "all_developers";
    }

    @GetMapping("/organisation/{developer_name}")
    public String moreDetailsOfDevelopers(@PathVariable("developer_name") String name, Model model) {
        String developerName = name.replace("-", " ");
        List<Developer> developerList = developerRepository.findAllByName(developerName);
        if (!developerList.isEmpty()) {
            model.addAttribute("developer", developerList.get(0));

            List<Property> properties = new ArrayList<>();
            int i = 0;
            while (properties.size() < 6 && i <= developerList.get(0).getComplexList().size()-1) {
                properties.addAll(developerList.get(0).getComplexList().get(i).getPropertyList());
                i++;
            }
            if (properties.size() > 5)
                properties = properties.subList(0, 6);
            model.addAttribute("properties", properties);

            return "developerPage";
        }
        return "homePage";
    }

    @GetMapping("/property/page/{numberOfPage}")
    public String properties(@PathVariable(required = false) Integer numberOfPage, Model model) {
        List<Property> properties = propertyRepository.findAll();
        model.addAttribute("properties", properties);
        if(numberOfPage != null)
            model.addAttribute("number", numberOfPage);
        return "all_properties";
    }
}