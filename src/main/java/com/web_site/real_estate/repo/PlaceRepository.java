package com.web_site.real_estate.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import com.web_site.real_estate.models.Place;

public interface PlaceRepository extends JpaRepository<Place, Integer> {

}
