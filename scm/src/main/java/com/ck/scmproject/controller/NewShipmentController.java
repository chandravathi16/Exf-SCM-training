package com.ck.scmproject.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.ck.scmproject.model.NewShipment;
import com.ck.scmproject.model.Signup;
import com.ck.scmproject.service.NewShipmentService;

@CrossOrigin
@RestController
public class NewShipmentController {

    @Autowired
    NewShipmentService newShipmentService;

    // To store the created shipments - POST mapping 
    @PostMapping("/addShipment")
    private String addShipment(@RequestBody NewShipment newShipment) {
        try {
            // Call the service method to create a new shipment
            return newShipmentService.createShipment(newShipment);
        } catch (Exception e) {
            return "Failed to create shipment: " + e.getMessage();
        }
    }
    
    // To display list of shipments in JSON format (in postman)
    @GetMapping(value = "/getShipments", produces = MediaType.APPLICATION_JSON_VALUE)
    public Object getShipmentData(Signup user) {
        try {
            return newShipmentService.getShipmentData(user);
        } catch (Exception e) {
            return "Failed to retrieve shipments: " + e.getMessage();
        }
    }   
}
