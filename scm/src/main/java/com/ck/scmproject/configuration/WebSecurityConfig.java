package com.ck.scmproject.configuration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    private UserDetailsService userDetailsService;

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userDetailsService).passwordEncoder(passwordEncoder());

        // Set admin credentials - only admin and chief admin are the admins 
        auth.inMemoryAuthentication()
            .withUser("admin@gmail.com")
            .password(passwordEncoder().encode("password"))
            .roles("ADMIN");

        // superadmin as main admin 
        auth.inMemoryAuthentication()
            .withUser("superadmin@gmail.com")
            .password(passwordEncoder().encode("password"))
            .roles("ADMIN");
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
    	http.csrf().disable()
        	.authorizeRequests()
            .mvcMatchers("/signup", "/login", "/forgotpassword", "/addShipment", "/getShipments")
            //.mvcMatchers("/signup", "/login","/forgotpassword")
            .permitAll()
            .antMatchers("/admin/**").hasRole("ADMIN")
            .anyRequest().authenticated()    
            .and()
            .formLogin()
            .loginPage("/login")
            //.defaultSuccessUrl("/home", true)
            .successHandler((request, response, authentication) -> {
                for (GrantedAuthority authority : authentication.getAuthorities()) {
                    if (authority.getAuthority().equals("ADMIN")) {
                        response.sendRedirect("/home"); // Admin role success URL
                    } else if (authority.getAuthority().equals("USER")) {
                        response.sendRedirect("/dashboard"); // User role success URL
                    }
                }
            })
            .failureUrl("/loginerror")
            .permitAll()
            .and()
            .sessionManagement()
            .maximumSessions(1)
            .expiredUrl("/login");
    }
   
    
    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
    
   
    
    /*
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.csrf().disable()
            .authorizeRequests()
                .mvcMatchers("/signup", "/login", "/forgotpassword").permitAll()
                .antMatchers("/addShipment").hasRole("USER")
                .antMatchers("/addShipment", "/getData").hasRole("ADMIN")
                .anyRequest().authenticated()
            .and()
            .formLogin()
                .loginPage("/login")
                .successHandler((request, response, authentication) -> {
                    for (GrantedAuthority authority : authentication.getAuthorities()) {
                        if (authority.getAuthority().equals("ADMIN")) {
                            response.sendRedirect("/home"); // Admin role success URL
                        } else if (authority.getAuthority().equals("USER")) {
                            response.sendRedirect("/dashboard"); // User role success URL
                        }
                    }
                })
                .failureUrl("/loginerror")
                .permitAll()
            .and()
            .sessionManagement()
                .maximumSessions(1)
                .expiredUrl("/login");
    }
    */

   
}
