package com.ck.scmproject.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import com.ck.scmproject.model.NewShipment;
import com.ck.scmproject.model.Signup;
import com.ck.scmproject.repository.NewShipmentRepository;
import com.ck.scmproject.repository.SignupRepository;

@Service
public class NewShipmentService {

    @Autowired
    private NewShipmentRepository newShipmentRepository;

    @Autowired
    private SignupRepository signupRepository;

    public String createShipment(NewShipment newShipment) throws Exception {
        // Check if a shipment with the given shipment number already exists
        boolean check = newShipmentRepository.existsByShipmentNumber(newShipment.getShipmentNumber());

        if (!check) {
            // If the shipment number doesn't exist, save the new shipment
            newShipmentRepository.save(newShipment);
            return "Shipment " + newShipment.getShipmentNumber() + " is successfully created!";
        }

        // If the shipment number already exists, throw an exception indicating the duplication
        throw new Exception("Shipment " + newShipment.getShipmentNumber() + " already exists!");
    }

    public Object getShipmentData(@RequestBody Signup user) throws Exception {
        String email = user.getEmail(); // Retrieve the email from the Signup object

        boolean exists = signupRepository.existsByEmail(email);
        if (!exists) {
            throw new Exception("No user found with this email " + email);
        }

        return newShipmentRepository.findAll();
    }
}
