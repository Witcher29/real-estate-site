package com.web_site.real_estate.repo;

import com.web_site.real_estate.models.Administrator;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AdministratorRepository extends JpaRepository<Administrator, Integer> {
    public Administrator findByUsername(String username);
}
