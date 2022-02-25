package com.car.garage.controller;

import com.car.garage.model.OilChange;
import com.car.garage.service.OilChangeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/api/vehicles" )
public class OilChangeController {

    private OilChangeService oilChangeService;

    @Autowired
    public void setOilChangeService(OilChangeService oilChangeService) {
        this.oilChangeService = oilChangeService;
    }

    @GetMapping("/{vehicleId}/oil")
    public List<OilChange> getAllOilChanges(@PathVariable (value = "vehicleId") Long vehicleId) {
        System.out.println("calling AllOilChanges");
        return oilChangeService.getAllOilChanges(vehicleId);
    }

    @PostMapping("/{vehicleId}/oil")
    public OilChange createOilChange(@PathVariable (value = "vehicleId") Long vehicleId, @RequestBody OilChange oilChangeObject) {
        System.out.println("Creating Oil Change");
        return oilChangeService.createOilChange(vehicleId, oilChangeObject);
    }
}
