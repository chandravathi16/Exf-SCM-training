package com.ck.scmproject.controller;

import com.ck.scmproject.repository.MyShipmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MyShipmentController {

    private final MyShipmentRepository shipmentRepository;

    @Autowired
    public MyShipmentController(MyShipmentRepository shipmentRepository) {
        this.shipmentRepository = shipmentRepository;
    }
    
    // To see the list of shipments in UI page (tabular format)
    @GetMapping("/shipments")
    public String myShipments(Model model) {
        try {
            // Retrieve all shipments from the repository and add them to the model
            model.addAttribute("MyShipments", shipmentRepository.findAll());
            return "shipments_list";
        } catch (Exception e) {
            // Log or handle the exception
            throw new RuntimeException("Failed to retrieve shipments: " + e.getMessage(), e);
        }
    }
}
