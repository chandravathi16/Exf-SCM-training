package com.ck.scmproject.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.security.crypto.password.PasswordEncoder;

import com.ck.scmproject.model.Signup;
import com.ck.scmproject.repository.SignupRepository;

@Service
public class SignupService {

    @Autowired
    private SignupRepository signupRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    // create an account with roles - USER & ADMIN
    public String createUser(Signup user) throws Exception {
        boolean exists = signupRepository.existsByEmail(user.getEmail());
        if (!exists) {
            user.setPassword(passwordEncoder.encode(user.getPassword()));
            // admin and chief admins have access to see device data
            if (user.getEmail().equals("admin@gmail.com") || user.getEmail().equals("superadmin@gmail.com")) {
                user.setRole("ADMIN");
            } else {
                user.setRole("USER");
            }
            user.setAccess(true);
            signupRepository.save(user);
            return user.getUsername() + " registered successfully with role: " + user.getRole();
        } else {
            throw new Exception(user.getEmail() + " already exists!");
        }
    }

    public String updatePassword(String email, String newPassword) throws Exception {
        Optional<Signup> userOptional = signupRepository.findUserByEmail(email);
        if (userOptional.isPresent()) {
            Signup user = userOptional.get();
            user.setPassword(passwordEncoder.encode(newPassword));
            signupRepository.save(user);
            return "Password updated successfully for user " + email;
        } else {
            throw new Exception("User " + email + " does not exist!");
        }
    }
}
