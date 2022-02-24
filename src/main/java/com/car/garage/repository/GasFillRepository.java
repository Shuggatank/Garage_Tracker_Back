package com.car.garage.repository;

import com.car.garage.model.GasFill;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GasFillRepository extends JpaRepository<GasFill, Long> {
}
