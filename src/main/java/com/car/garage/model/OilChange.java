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
    @JoinColumn(name = "vehicle_id", nullable = false)
    private Vehicle vehicle;

    public OilChange() {
    }

    public OilChange(Long id, Long mileage, Date date, String oilGrade, String oilFilter) {
        this.id = id;
        this.mileage = mileage;
        this.date = date;
        this.oilGrade = oilGrade;
        this.oilFilter = oilFilter;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getMileage() {
        return mileage;
    }

    public void setMileage(Long mileage) {
        this.mileage = mileage;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getOilGrade() {
        return oilGrade;
    }

    public void setOilGrade(String oilGrade) {
        this.oilGrade = oilGrade;
    }

    public String getOilFilter() {
        return oilFilter;
    }

    public void setOilFilter(String oilFilter) {
        this.oilFilter = oilFilter;
    }

    public Vehicle getVehicle() {
        return vehicle;
    }

    public void setVehicle(Vehicle vehicle) {
        this.vehicle = vehicle;
    }

    @Override
    public String toString() {
        return "OilChange{" +
                "id=" + id +
                ", mileage=" + mileage +
                ", date=" + date +
                ", oilGrade='" + oilGrade + '\'' +
                ", oilFilter='" + oilFilter + '\'' +
                ", vehicleId=" + vehicle +
                '}';
    }
}
