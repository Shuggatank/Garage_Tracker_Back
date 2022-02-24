package com.car.garage.service;

import com.car.garage.model.GasFill;
import com.car.garage.model.Vehicle;
import com.car.garage.repository.GasFillRepository;
import com.car.garage.repository.VehicleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

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
        Vehicle vehicle = vehicleRepository.findById(vehicleId).get();
        return vehicle.getGasFillList();
    }

    public GasFill createGasFill(Long vehicleId, GasFill gasFillObject) {
        Vehicle vehicle = vehicleRepository.findById(vehicleId).get();
        gasFillObject.setVehicle(vehicle);
        return gasFillRepository.save(gasFillObject);
    }
}
