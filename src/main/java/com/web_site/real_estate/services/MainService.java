package com.web_site.real_estate.services;

import com.web_site.real_estate.models.Property;
import com.web_site.real_estate.repo.PropertyRepository;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
@NoArgsConstructor
public class MainService {

    private PropertyRepository propertyRepository;

    @Autowired
    public MainService(PropertyRepository propertyRepository) {
        this.propertyRepository = propertyRepository;
    }
    Map<Integer, String> mapOfProperties = new HashMap<>();

    //создание ссылок по кнопке More Details
    public Map<Integer, String> makeNameOfPropertyReference() {
        List<Property> listOfProperties = propertyRepository.findAll();
        Property property;
        for (int i=0; i<listOfProperties.size(); i++) {
            property = listOfProperties.get(i);
            mapOfProperties.put(property.getId(), property.getBedrooms() + "-bedrooms-in-" + property.getComplex_name() + "-" + property.getId());
        }
        return mapOfProperties;
    }
}
