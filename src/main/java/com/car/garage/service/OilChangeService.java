package com.car.garage.service;

import com.car.garage.exceptions.InformationNotFoundException;
import com.car.garage.model.OilChange;
import com.car.garage.model.Vehicle;
import com.car.garage.repository.OilChangeRepository;
import com.car.garage.repository.VehicleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class OilChangeService {
    private OilChangeRepository oilChangeRepository;
    private VehicleRepository vehicleRepository;

    @Autowired
    public void setOilChangeRepository (OilChangeRepository oilChangeRepository) {
        this.oilChangeRepository = oilChangeRepository;
    }

    @Autowired
    public void setVehicleRepository (VehicleRepository vehicleRepository) {
        this.vehicleRepository = vehicleRepository;
    }

    public List<OilChange> getAllOilChanges(Long vehicleId) {
        Optional<Vehicle> vehicle = vehicleRepository.findById(vehicleId);
        if (vehicle.isPresent()) {
            return vehicle.get().getOilChangeList();
        } else {
            throw new InformationNotFoundException("Vehicle does not exist");
        }
    }

    public OilChange createOilChange(Long vehicleId, OilChange oilChangeObject) {
        Optional<Vehicle> vehicle = vehicleRepository.findById(vehicleId);
        if (vehicle.isPresent()) {
            oilChangeObject.setVehicle(vehicle.get());
            return oilChangeRepository.save(oilChangeObject);
        }else {
            throw new InformationNotFoundException("Vehicle does not exist");
        }
    }
}
