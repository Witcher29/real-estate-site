package com.web_site.real_estate.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import com.web_site.real_estate.models.District;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface DistrictRepository extends JpaRepository<District, Integer> {
    @Query("SELECT d FROM District d WHERE d.name = :name")
    List<District> findAllByName(@Param("name") String name);
}
