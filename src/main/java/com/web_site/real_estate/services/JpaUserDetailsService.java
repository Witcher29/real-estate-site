package com.web_site.real_estate.services;

import com.web_site.real_estate.models.Administrator;
import com.web_site.real_estate.repo.AdministratorRepository;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Optional;

public class JpaUserDetailsService implements UserDetailsService {
    private final AdministratorRepository administratorRepository;
    private final PasswordEncoder passwordEncoder;

    public JpaUserDetailsService(AdministratorRepository administratorRepository, PasswordEncoder passwordEncoder) {
        this.administratorRepository = administratorRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<Administrator> administratorOptional = Optional.ofNullable(administratorRepository.findByUsername(username));
        Administrator administrator;
        if (administratorOptional.isPresent()){
            administrator = administratorOptional.get();

            LocalDateTime now = LocalDateTime.now();
            String formattedLastLogin = now.format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
            administrator.setLast_login(LocalDateTime.parse(formattedLastLogin, DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")));
            administratorRepository.save(administrator);
        }
        else throw new UsernameNotFoundException("This username isn't in database");

        return new User(
                administrator.getUsername(),
                administrator.getPassword(),
                true, true, true, true,
                AuthorityUtils.createAuthorityList("ROLE_ADMIN")
        );
    }
}