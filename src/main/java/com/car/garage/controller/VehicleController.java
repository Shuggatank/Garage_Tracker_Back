package com.car.garage.controller;


import com.car.garage.model.Vehicle;
import com.car.garage.service.VehicleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin(origins = "https://garagetracker.herokuapp.com")
@RequestMapping("/api" )
public class VehicleController {

    private VehicleService vehicleService;

    @Autowired
    public void setVehicleService(VehicleService vehicleService) {
        this.vehicleService = vehicleService;
    }
    @GetMapping("/vehicles")
    public List<Vehicle> getAllVehicles() {
        System.out.println("Calling getAllVehicles");
        return vehicleService.getAllVehicles();
    }

    @PostMapping("/vehicles")
    public Vehicle createVehicle(@RequestBody Vehicle vehicleObject) {
        System.out.println("Creating a new vehicle");
        return vehicleService.createVehicle(vehicleObject);
    }

    @GetMapping("/vehicles/{vehicleId}")
    public Optional<Vehicle> getVehicle(@PathVariable(value = "vehicleId") Long vehicleId) {
        System.out.println("Calling getAllVehicles");
        return vehicleService.getVehicle(vehicleId);
    }

}
