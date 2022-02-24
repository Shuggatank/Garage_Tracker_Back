package com.car.garage.service;

import com.car.garage.exceptions.InformationExistsException;
import com.car.garage.model.Vehicle;
import com.car.garage.repository.VehicleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class VehicleService {
    private VehicleRepository vehicleRepository;

    @Autowired
    public void setVehicleRepository(VehicleRepository vehicleRepository) {
        this.vehicleRepository = vehicleRepository;
    }

    public List<Vehicle> getAllVehicles() {
        System.out.println("Calling getAllVehicles");
        return vehicleRepository.findAll();
    }

    public Vehicle createVehicle(Vehicle vehicleObject) {
        Optional<Vehicle> vehicle = vehicleRepository.findById(vehicleObject.getId());
        if(vehicle.isPresent()) {
            throw new InformationExistsException("Vehicle already exists");
        }
        return vehicleRepository.save(vehicleObject);
    }
}
