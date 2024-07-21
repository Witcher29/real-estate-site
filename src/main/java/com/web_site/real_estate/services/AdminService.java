package com.web_site.real_estate.services;

import com.web_site.real_estate.models.Administrator;
import com.web_site.real_estate.repo.AdministratorRepository;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class AdminService {
    private final AdministratorRepository administratorRepository;
    private final PasswordEncoder passwordEncoder;

    public AdminService(AdministratorRepository administratorRepository, PasswordEncoder passwordEncoder) {
        this.administratorRepository = administratorRepository;
        this.passwordEncoder = passwordEncoder;
    }

    public void createAdmin(String username, String password) {
        Administrator admin = new Administrator();
        admin.setUsername(username);
        admin.setPassword(passwordEncoder.encode(password));
        administratorRepository.save(admin);
    }
}
