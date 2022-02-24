package com.car.garage.service;

import com.car.garage.exceptions.InformationNotFoundException;
import com.car.garage.model.GasFill;
import com.car.garage.model.Vehicle;
import com.car.garage.repository.GasFillRepository;
import com.car.garage.repository.VehicleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class GasFillService {
    private GasFillRepository gasFillRepository;
    private VehicleRepository vehicleRepository;

    @Autowired
    public void setGasFillRepository (GasFillRepository gasFillRepository) {
        this.gasFillRepository = gasFillRepository;
    }

    @Autowired
    public void setVehicleRepository (VehicleRepository vehicleRepository) {
        this.vehicleRepository = vehicleRepository;
    }

    public List<GasFill> getAllGasFills(Long vehicleId) {
        Optional<Vehicle> vehicle = vehicleRepository.findById(vehicleId);
        if (vehicle.isPresent()) {
            return vehicle.get().getGasFillList();
        } else {
            throw new InformationNotFoundException("Vehicle does not exist");
        }
    }

    public GasFill createGasFill(Long vehicleId, GasFill gasFillObject) {
        Optional<Vehicle> vehicle = vehicleRepository.findById(vehicleId);
        if (vehicle.isPresent()) {
            gasFillObject.setVehicle(vehicle.get());
            return gasFillRepository.save(gasFillObject);
        } else {
            throw new InformationNotFoundException("Vehicle does not exist");
        }
    }
}
