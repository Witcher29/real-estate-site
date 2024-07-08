package com.web_site.real_estate.repo;

import com.web_site.real_estate.models.Developer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface DeveloperRepository extends JpaRepository<Developer, Integer> {
    @Query("SELECT d FROM Developer d WHERE d.name = :name")
    List<Developer> findAllByName(@Param("name") String name);
}
