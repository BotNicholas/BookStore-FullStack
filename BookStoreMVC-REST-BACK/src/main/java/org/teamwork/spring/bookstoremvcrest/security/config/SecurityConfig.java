//package org.teamwork.spring.bookstoremvcrest.security.config;
//
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.security.config.Customizer;
//import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
//import org.springframework.security.config.annotation.web.builders.HttpSecurity;
//import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
//import org.springframework.security.config.annotation.web.configurers.AbstractAuthenticationFilterConfigurer;
//import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
//import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
//import org.springframework.security.crypto.password.PasswordEncoder;
//import org.springframework.security.web.SecurityFilterChain;
//
//@Configuration
//@EnableWebSecurity
//@EnableMethodSecurity
//public class SecurityConfig {
//    @Bean
//    public SecurityFilterChain securityFilterChain(HttpSecurity security) throws Exception {
//        security.cors(AbstractHttpConfigurer::disable);
//        security.csrf(AbstractHttpConfigurer::disable);
//        security.authorizeHttpRequests(request -> request.requestMatchers("/").permitAll());
//        security.authorizeHttpRequests(request -> request.requestMatchers("/users/register").permitAll());
//        security.authorizeHttpRequests(request -> request.requestMatchers("/doc").hasAnyRole("ADMIN", "MANAGER"));
//        security.authorizeHttpRequests(request -> request.requestMatchers("/swagger-ui/**").hasAnyRole("ADMIN", "MANAGER"));
//        security.authorizeHttpRequests(request -> request.requestMatchers("/**").authenticated());
//        security.formLogin(AbstractAuthenticationFilterConfigurer::permitAll);
//        security.httpBasic(Customizer.withDefaults());
//        return security.build();
//    }
//
//    @Bean
//    public PasswordEncoder passwordEncoder() {
//        return new BCryptPasswordEncoder();
//    }
//}
