package com.ck.scmproject.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.ck.scmproject.model.Signup;
import com.ck.scmproject.repository.SignupRepository;

@RestController
public class ForgotPasswordController {

    @Autowired
    private SignupRepository signupRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @PutMapping("/signup/{username}/password")
    public String updatePassword(@PathVariable String username, @RequestBody UpdatePasswordRequest updatePasswordRequest) {
        Optional<Signup> userOptional = signupRepository.findUserByEmail(username);
        if (!userOptional.isPresent()) {
            return "User not found";
        }

        Signup user = userOptional.get();

        if (!passwordEncoder.matches(updatePasswordRequest.getCurrentPassword(), user.getPassword())) {
            return "Invalid credentials";
        }

        String hashedPassword = passwordEncoder.encode(updatePasswordRequest.getNewPassword());

        user.setPassword(hashedPassword);
        signupRepository.save(user);

        return "Password updated successfully";
    }

    static class UpdatePasswordRequest {
        private String currentPassword;
        private String newPassword;

        public String getCurrentPassword() {
            return currentPassword;
        }

        public void setCurrentPassword(String currentPassword) {
            this.currentPassword = currentPassword;
        }

        public String getNewPassword() {
            return newPassword;
        }

        public void setNewPassword(String newPassword) {
            this.newPassword = newPassword;
        }
    }
}
