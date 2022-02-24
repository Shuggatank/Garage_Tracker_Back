package com.car.garage.controller;


import com.car.garage.model.Vehicle;
import com.car.garage.service.VehicleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
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

}
