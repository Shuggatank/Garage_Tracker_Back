package com.car.garage.service;

import com.car.garage.model.OilChange;
import com.car.garage.repository.OilChangeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OilChangeService {
    private OilChangeRepository oilChangeRepository;

    @Autowired
    public void setOilChangeRepository (OilChangeRepository oilChangeRepository) {
        this.oilChangeRepository = oilChangeRepository;
    }

    public List<OilChange> getAllOilChanges() {
        return oilChangeRepository.findAll();
    }

    public OilChange createOilChange(OilChange oilChangeObject) {
        return oilChangeRepository.save(oilChangeObject);
    }
}
