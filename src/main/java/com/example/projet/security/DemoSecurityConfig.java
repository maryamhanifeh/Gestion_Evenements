package com.example.projet.security;

import jakarta.servlet.http.HttpServlet;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class DemoSecurityConfig {

    @Bean
    public InMemoryUserDetailsManager userDetailsManager(){
        UserDetails mehdi = User.builder()
                .username("medhi")
                .password("{noop}test123")
                .roles("User")
                .build();

        UserDetails maryam = User.builder()
                .username("maryam")
                .password("{noop}test123")
                .roles("User", "Manager")
                .build();

        UserDetails mary = User.builder()
                .username("mary")
                .password("{noop}test123")
                .roles("User", "Manager", "ADMIN")
                .build();

        return new InMemoryUserDetailsManager(mehdi, maryam, mary);
    }

    //restricting access based on roles
    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http)throws Exception{
        http.authorizeHttpRequests(configurer ->
                configurer
                        .requestMatchers(HttpMethod.GET, "api/users").hasRole("User")
                        .requestMatchers(HttpMethod.GET, "api/users/**").hasRole("User")
                        .requestMatchers(HttpMethod.POST, "api/users").hasRole("Manager")
                        .requestMatchers(HttpMethod.PUT, "api/users").hasRole("Manager")
                        .requestMatchers(HttpMethod.DELETE, "api/users/**").hasRole("Admin")

        );
        // use HTTP Basic authentication
        http.httpBasic(Customizer.withDefaults());

        //disable Cross Site Request Forgery(CSRF    )
        http.csrf(AbstractHttpConfigurer::disable);
        return http.build();
    }
}
