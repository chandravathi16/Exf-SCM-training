package com.ck.scmproject.configuration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.ck.scmproject.model.Signup;
import com.ck.scmproject.repository.SignupRepository;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class CustomUserDetailsService implements UserDetailsService {

    @Autowired
    private SignupRepository signupRepository;

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        // Find the user in the repository based on the provided email
        Optional<Signup> userOptional = signupRepository.findUserByEmail(email);

        // If no user is found, throw an exception indicating that no user was found with the provided email
        Signup user = userOptional.orElseThrow(() -> new UsernameNotFoundException("No user found with this email!"));

        // Create and return a UserDetails object representing the user
        return new org.springframework.security.core.userdetails.User(
                user.getEmail(), 
                user.getPassword(), 
                user.isAccess(), // Whether the user has access; Account is enabled; Account is not expired; Credentials are not expired
                true, 
                true, 
                true, 
                getAuthorities(user.getRole()) // Get the user's authorities based on their role
        );
    }

    private List<GrantedAuthority> getAuthorities(String role) {
        // Create a list to hold the user's authorities
        List<GrantedAuthority> authorities = new ArrayList<>();

        // Add a single authority based on the user's role
        authorities.add(new SimpleGrantedAuthority(role));

        return authorities;
    }
}
