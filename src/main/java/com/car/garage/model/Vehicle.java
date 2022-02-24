package com.car.garage.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name="vehicles")
public class Vehicle {

    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String vin;

    @Column
    private String make;

    @Column
    private String model;

    @Column
    private Long year;

    @OneToMany(mappedBy = "vehicle", orphanRemoval = true)
    @LazyCollection(LazyCollectionOption.FALSE)
    private List<OilChange> oilChangeList;

    @OneToMany(mappedBy = "vehicle", orphanRemoval = true)
    @LazyCollection(LazyCollectionOption.FALSE)
    private List<GasFill> gasFillList;

    @OneToMany(mappedBy = "vehicle", orphanRemoval = true)
    @LazyCollection(LazyCollectionOption.FALSE)
    private List<MaintenanceRecord> maintenanceRecordList;

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    public Vehicle() {
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Vehicle(Long id, String vin, String make, String model, Long year) {
        this.id = id;
        this.vin = vin;
        this.make = make;
        this.model = model;
        this.year = year;

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getVin() {
        return vin;
    }

    public void setVin(String vin) {
        this.vin = vin;
    }

    public String getMake() {
        return make;
    }

    public void setMake(String make) {
        this.make = make;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public Long getYear() {
        return year;
    }

    public void setYear(Long year) {
        this.year = year;
    }

    public List<OilChange> getOilChangeList() {
        return oilChangeList;
    }

    public void setOilChangeList(List<OilChange> oilChangeList) {
        this.oilChangeList = oilChangeList;
    }

    public List<GasFill> getGasFillList() {
        return gasFillList;
    }

    public void setGasFillList(List<GasFill> gasFillList) {
        this.gasFillList = gasFillList;
    }

    public List<MaintenanceRecord> getMaintenanceRecordList() {
        return maintenanceRecordList;
    }

    public void setMaintenanceRecordListList(List<MaintenanceRecord> maintenanceRecordList) {
        this.maintenanceRecordList = maintenanceRecordList;
    }

    @Override
    public String toString() {
        return "Vehicle{" +
                "id=" + id +
                ", vin='" + vin + '\'' +
                ", make='" + make + '\'' +
                ", model='" + model + '\'' +
                ", year=" + year +
                ", oilChangeList=" + oilChangeList +
                ", gasFillList=" + gasFillList +
                ", maintenanceRecordList=" + maintenanceRecordList +
                '}';
    }
}
