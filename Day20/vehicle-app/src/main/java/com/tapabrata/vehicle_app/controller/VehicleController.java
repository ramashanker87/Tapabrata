package com.tapabrata.vehicle_app.controller;

import com.tapabrata.vehicle_app.model.Owner;
import com.tapabrata.vehicle_app.model.Vehicle;
import com.tapabrata.vehicle_app.service.VehicleService;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


@RestController
@RequestMapping("/vehicle")
public class VehicleController {
    private static final Logger logger = LoggerFactory.getLogger(VehicleController.class);

    @Autowired
    private VehicleService vehicleService;

    @PostMapping("/register")
    public String registerVehicle(@RequestBody Vehicle vehicle, @RequestBody Owner owner) {
        logger.info("Registering vehicle with number: " + vehicle.getVehicleNumber());
        vehicleService.registerVehicle(vehicle, owner);
        return "Vehicle Registered!";
    }

    @DeleteMapping("/deregister")
    public String deregisterVehicle(@RequestParam String vehicleNumber) {
        logger.info("Deregistering vehicle with number: " + vehicleNumber);
        vehicleService.deregisterVehicle(vehicleNumber);
        return "Vehicle Deregistered!";
    }
}
