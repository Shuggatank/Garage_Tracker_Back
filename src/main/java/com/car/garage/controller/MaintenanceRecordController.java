package com.car.garage.controller;

import com.car.garage.model.MaintenanceRecord;
import com.car.garage.service.MaintenanceRecordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/vehicles" )
public class MaintenanceRecordController {

    private MaintenanceRecordService maintenanceRecordService;

    @Autowired
    public void setMaintenanceRecordService(MaintenanceRecordService maintenanceRecordService) {
        this.maintenanceRecordService = maintenanceRecordService;
    }

    @GetMapping("/{vehicleId}/maintenancerecord")
    public List<MaintenanceRecord> getAllMaintenanceRecords(@PathVariable(value = "vehicleId") Long vehicleId) {
        System.out.println("calling AllMaintenanceRecords");
        return maintenanceRecordService.getAllMaintenanceRecords(vehicleId);
    }

    @PostMapping("/{vehicleId}/maintenancerecord")
    public MaintenanceRecord createMaintenanceRecord(@PathVariable (value = "vehicleId") Long vehicleId, @RequestBody MaintenanceRecord recordObject) {
        System.out.println("Creating Maintenance Record");
        return maintenanceRecordService.createMaintenanceRecord(vehicleId, recordObject);
    }
}
