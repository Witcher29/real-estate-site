package com.web_site.real_estate.repo;

import com.web_site.real_estate.models.Property;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PropertyRepository extends JpaRepository<Property, Integer> {
}
