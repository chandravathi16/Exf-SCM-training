package com.ck.scmproject.controller;

import java.security.Principal;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class HomeController {
	
	@GetMapping("/home")
	public String welcome(Model model, Principal principal) {
		model.addAttribute("username", principal.getName());
		return "home";
	}
	
	@GetMapping("/dashboard")
	public String dashboard(Model model, Principal principal) {
		model.addAttribute("username", principal.getName());
		return "dashboard";
	}

	@GetMapping("/login")
	public String login(Model model) {
		return "login";
	}
	
	@GetMapping("/signup")
	public String signup(Model model) {
		return "signup";
	}
	
	@GetMapping("/loginerror")
	public String loginerror(Model model) {
    	model.addAttribute("message","Invalid Credentials!");
    	return "login";
    }
	
	@GetMapping("/addShipment")
	public String addShipment(Model model, @RequestParam(value = "success", required = false) String success, @RequestParam(value = "error", required = false) String error) {
		if (success != null) {
			model.addAttribute("success", success);
		} else {
			model.addAttribute("error", error);
		}
    	return "newshipment";
    }
	
	@GetMapping("/usererror")
	public String signerror(Model model) {
		model.addAttribute("message1", "Email already exists! Login");
    	return "signup";
    }
	   
	@GetMapping("/forgotpassword")
    public String forgotpassword(Model model) {
        return "forgotpassword";
    }
	
	@GetMapping("/createShipment")
	public String createShipment(Model model, @RequestParam(value = "success", required = false) String success, @RequestParam(value = "error", required = false) String error) {
		if (success != null) {
			model.addAttribute("success", success);
		} else {
			model.addAttribute("error", error);
		}
    	return "shipment";
    }
	
   
}
