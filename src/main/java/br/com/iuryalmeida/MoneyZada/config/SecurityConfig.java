package br.com.iuryalmeida.MoneyZada.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    @Bean
    public BCryptPasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http.csrf().disable()
            .authorizeHttpRequests(authorizeRequests -> authorizeRequests
                .requestMatchers("/users/register").permitAll() // Permitir acesso ao endpoint de registro
                .requestMatchers("/h2-console/**").permitAll() // Permitir acesso ao console do H2
                .requestMatchers("/transactions**").permitAll() // Permitir acesso ao console do H2
                .anyRequest().authenticated()
            )
            .formLogin(formLogin -> formLogin
                .permitAll() // Permitir acesso à página de login
            )
            .logout(logout -> logout
                .permitAll() // Permitir logout
            )
            .headers(headers -> headers
                .frameOptions().sameOrigin() // Permitir que o console do H2 seja carregado em um iframe
            );
        return http.build();
    }
}