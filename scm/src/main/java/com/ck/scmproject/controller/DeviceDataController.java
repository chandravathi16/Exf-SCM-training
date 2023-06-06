package com.ck.scmproject.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.ck.scmproject.repository.DeviceDataRepository;

@Controller
public class DeviceDataController {

    @Autowired
    DeviceDataRepository deviceDataRepository;

    // To see the device data in UI
    @RequestMapping(value = "/getData", method = RequestMethod.GET)
    public String dashboard(Model model) {
        try {
            // Retrieve all device data from the repository and add it to the model
            model.addAttribute("DeviceData", deviceDataRepository.findAll());
            return "devicedata";
        } catch (Exception e) {
            // Log or handle the exception
            throw new RuntimeException("Failed to retrieve device data: " + e.getMessage(), e);
        }
    }
}
