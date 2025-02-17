package com.tapabrata.vehicle_app.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;



@RestController
@RequestMapping("/owner")
public class OwnerController {
    private static final Logger logger = (Logger) LoggerFactory.getLogger(OwnerController.class);

    @GetMapping("/details")
    public String getOwnerDetails(@RequestParam String vehicleNumber) {
        logger.debug("Fetching details for vehicle number: " + vehicleNumber);
        return "Owner Details Retrieved!";
    }
}
