package com.web_site.real_estate.repo;

import com.web_site.real_estate.models.Property;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PropertyRepository extends JpaRepository<Property, Integer> {
    List<Property> findAllByBedrooms(Integer bedrooms);
}
