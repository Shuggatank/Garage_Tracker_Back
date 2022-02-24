package com.car.garage.service;

import com.car.garage.exceptions.InformationNotFoundException;
import com.car.garage.model.MaintenanceRecord;
import com.car.garage.model.Vehicle;
import com.car.garage.repository.MaintenanceRecordRepository;
import com.car.garage.repository.VehicleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MaintenanceRecordService {
    private MaintenanceRecordRepository maintenanceRecordRepository;
    private VehicleRepository vehicleRepository;


    @Autowired
    public void setMaintenanceRecordRepository (MaintenanceRecordRepository maintenanceRecordRepository) {
        this.maintenanceRecordRepository = maintenanceRecordRepository;
    }

    @Autowired
    public void setVehicleRepository (VehicleRepository vehicleRepository) {
        this.vehicleRepository = vehicleRepository;
    }

    public List<MaintenanceRecord> getAllMaintenanceRecords(Long vehicleId) {
        Optional<Vehicle> vehicle = vehicleRepository.findById(vehicleId);
        if (vehicle.isPresent()) {
            return vehicle.get().getMaintenanceRecordList();
        } else {
            throw new InformationNotFoundException("Vehicle does not exist");
        }
    }

    public MaintenanceRecord createMaintenanceRecord(Long vehicleId, MaintenanceRecord recordObject) {
        Optional<Vehicle> vehicle = vehicleRepository.findById(vehicleId);
        if (vehicle.isPresent()) {
            recordObject.setVehicle(vehicle.get());
            return maintenanceRecordRepository.save(recordObject);
        } else {
            throw new InformationNotFoundException("Vehicle does not exist");
        }
    }
}
