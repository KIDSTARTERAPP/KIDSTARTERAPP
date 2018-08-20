package com.javamentor.kidstarter.security.config;

import com.javamentor.kidstarter.security.handler.SecurityHandler;
import com.javamentor.kidstarter.security.service.AuthenticationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;


@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    private final AuthenticationService authenticationService;

    private final SecurityHandler securityHandler;

    private final PassEncode passwordEncoder;

    @Autowired
    public WebSecurityConfig(SecurityHandler securityHandler, AuthenticationService authenticationService, PassEncode passwordEncoder) {
        this.securityHandler = securityHandler;
        this.authenticationService = authenticationService;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public void configure(WebSecurity web) throws Exception {
        web.ignoring().antMatchers(HttpMethod.OPTIONS, "/main", "/style/**", "/scripts/**", "/", "/**");
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .csrf().disable()
                .authorizeRequests()
                .antMatchers("/home/**").permitAll()

                .antMatchers("/main", "/style/**", "/scripts/**", "/", "/api/**").permitAll()
                // TODO удалить "/tagPage", "/jobPage"
                .antMatchers("/main","/tagPage", "/jobPage", "/createUser", "/style/**", "/scripts/**", "/").permitAll()
                .antMatchers("/insert_user").permitAll()
                .antMatchers("/admin/**").hasAnyRole("ADMIN")
                .antMatchers("/user/**").hasAnyRole("USER")
                .anyRequest().authenticated()
                .and()
                .formLogin()
                .loginPage("/home/login")
                .permitAll()
                .successHandler(securityHandler)
                .and()
                .logout()
                .permitAll();
    }

    @Bean
    public DaoAuthenticationProvider authProvider() {
        DaoAuthenticationProvider authProvider = new DaoAuthenticationProvider();
        authProvider.setUserDetailsService(authenticationService);
        authProvider.setPasswordEncoder(passwordEncoder.passwordEncoder());
        return authProvider;
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.authenticationProvider(authProvider());
    }



}