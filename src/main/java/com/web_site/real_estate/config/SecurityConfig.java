package com.web_site.real_estate.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractAuthenticationFilterConfigurer;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    private String username = "ad";
    private String password = "ad";

    @Bean
    public UserDetailsService userDetailsService(PasswordEncoder encoder) {
        UserDetails admin = User.builder().username(username).password(encoder.encode(password)).build();

        return new InMemoryUserDetailsManager(admin);
    }

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        return http.csrf(AbstractHttpConfigurer::disable)
                .authorizeHttpRequests(auth -> auth.requestMatchers("/").permitAll()
                        .requestMatchers("/complex/**").permitAll()
                        .requestMatchers("/property/**").permitAll()
                        .requestMatchers("/organisations/**").permitAll()
                        .requestMatchers("/about-us").permitAll()
                        .requestMatchers("/contact-us").permitAll()
                        .requestMatchers("/district/**").permitAll()
                        .requestMatchers("/agent/**").permitAll()
                        .requestMatchers("contact-us").permitAll()
                        .requestMatchers("/admin**").authenticated()
                        .requestMatchers("/admin/**").authenticated())
                .formLogin(AbstractAuthenticationFilterConfigurer :: permitAll)
                .build();
    }
    @Bean
    public PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }
}
