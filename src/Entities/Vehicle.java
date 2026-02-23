package Entities;

import Entities.enums.VehicleStatus;

import java.math.BigDecimal;

public class Vehicle {
    private String model;
    private String color;
    private BigDecimal price;
    private int yearOfProduction;
    private Integer mileage;
    private VehicleStatus vehicleStatus;

    public Vehicle(String model, String color, VehicleStatus vehicleStatus, Integer mileage, int yearOfProduction, BigDecimal price) {
        this.model = model;
        this.color = color;
        this.vehicleStatus = vehicleStatus;
        this.mileage = mileage;
        this.yearOfProduction = yearOfProduction;
        this.price = price;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public int getYearOfProduction() {
        return yearOfProduction;
    }

    public void setYearOfProduction(int yearOfProduction) {
        this.yearOfProduction = yearOfProduction;
    }

    public Integer getMileage() {
        return mileage;
    }

    public void setMileage(Integer mileage) {
        this.mileage = mileage;
    }

    public VehicleStatus getVehicleStatus() {
        return vehicleStatus;
    }

    public void setVehicleStatus(VehicleStatus vehicleStatus) {
        this.vehicleStatus = vehicleStatus;
    }
}
