package com.ck.scmproject.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestParam;

import com.ck.scmproject.model.Signup;
import com.ck.scmproject.repository.SignupRepository;
import com.ck.scmproject.service.SignupService;

@CrossOrigin
@RestController
@Component
public class SignupController {

    @Autowired
    public SignupRepository signupRepository;

    @Autowired
    private SignupService signupService;

    // To store details of a new user - POST mapping 
    @PostMapping("/signup")
    public String addUser(@RequestBody Signup signup) {
        try {
            // Call the service method to create a new user
            return signupService.createUser(signup);
        } catch (Exception e) {
            return "Failed to create user: " + e.getMessage();
        }
    }

    @PostMapping("/updatepassword")
    public String updatePassword(@RequestParam String email, @RequestParam String password) {
        try {
            // Call the service method to update the password for a user with the given email
            return signupService.updatePassword(email, password);
        } catch (Exception e) {
            return "Failed to update password: " + e.getMessage();
        }
    }
}
