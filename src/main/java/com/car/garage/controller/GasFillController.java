package com.car.garage.controller;

import com.car.garage.model.GasFill;
import com.car.garage.model.OilChange;
import com.car.garage.service.GasFillService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "/**")
@RequestMapping("/api/vehicles" )
public class GasFillController {

    private GasFillService gasFillService;

    @Autowired
    public void setGasFillService (GasFillService gasFillService) {
        this.gasFillService = gasFillService;
    }

    @GetMapping("/{vehicleId}/gas")
    public List<GasFill> getAllGasFills(@PathVariable(value = "vehicleId") Long vehicleId) {
        System.out.println("calling AllGasFills");
        return gasFillService.getAllGasFills(vehicleId);
    }

    @PostMapping("/{vehicleId}/gas")
    public GasFill createGasFill(@PathVariable (value = "vehicleId") Long vehicleId, @RequestBody GasFill gasFillObject) {
        System.out.println("Creating Oil Change");
        return gasFillService.createGasFill(vehicleId, gasFillObject);
    }
}
