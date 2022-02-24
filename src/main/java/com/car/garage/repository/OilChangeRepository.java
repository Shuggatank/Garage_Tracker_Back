package com.car.garage.repository;

import com.car.garage.model.OilChange;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OilChangeRepository extends JpaRepository<OilChange, Long> {

}
