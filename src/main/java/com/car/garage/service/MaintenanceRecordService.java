package com.car.garage.service;

import com.car.garage.model.MaintenanceRecord;
import com.car.garage.model.Vehicle;
import com.car.garage.repository.MaintenanceRecordRepository;
import com.car.garage.repository.VehicleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

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
        Vehicle vehicle = vehicleRepository.findById(vehicleId).get();
        return vehicle.getMaintenanceRecordList();
    }

    public MaintenanceRecord createMaintenanceRecord(Long vehicleId, MaintenanceRecord recordObject) {
        Vehicle vehicle = vehicleRepository.findById(vehicleId).get();
        recordObject.setVehicle(vehicle);
        return maintenanceRecordRepository.save(recordObject);
    }
}
