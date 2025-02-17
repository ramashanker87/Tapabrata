package com.tapabrata.vehicle_app.service;

import com.tapabrata.vehicle_app.model.Owner;
import com.tapabrata.vehicle_app.model.Registration;
import com.tapabrata.vehicle_app.model.Vehicle;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class VehicleService {

    private Map<String, Registration> registrationMap = new HashMap<>();

    public void registerVehicle(Vehicle vehicle, Owner owner) {
        Registration registration = new Registration(owner, vehicle);
        registrationMap.put(vehicle.getVehicleNumber(), registration);
    }

    public void deregisterVehicle(String vehicleNumber) {
        registrationMap.remove(vehicleNumber);
    }

    public Registration getRegistration(String vehicleNumber) {
        return registrationMap.get(vehicleNumber);
    }
}
