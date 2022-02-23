package com.car.garage.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "oil_change")
public class OilChange {

    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private Long mileage;

    @Column
    private Date date;

    @Column
    private String oilGrade;

    @Column
    private String oilFilter;

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "vehicle_id")
    private Vehicle vehicle;
}
