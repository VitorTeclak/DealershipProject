package Entities;

import Entities.enums.VehicleStatus;

import java.math.BigDecimal;

public class Vehicle {
    private int vehicle_id;
    private String model;
    private String color;
    private BigDecimal price;
    private int yearOfProduction;
    private Integer mileage;
    private VehicleStatus vehicleStatus;

    public Vehicle() {
    }

    public Vehicle(int vehicle_id, String model, String color, VehicleStatus vehicleStatus, Integer mileage, int yearOfProduction, BigDecimal price) {
        this.vehicle_id = vehicle_id;
        this.model = model;
        this.color = color;
        this.vehicleStatus = vehicleStatus;
        this.mileage = mileage;
        this.yearOfProduction = yearOfProduction;
        this.price = price;
    }

    public int getVehicle_id() {
        return vehicle_id;
    }

    public void setVehicle_id(int vehicle_id) {
        this.vehicle_id = vehicle_id;
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

    @Override
    public String toString() {
        return "Vehicle ID: " + getVehicle_id()  + " | " +
                "Model: " + getModel()  + " | " +
                "Color: " + getColor()  + " | " +
                "Price: " + getPrice()  + " | " +
                "Year of production: " + getYearOfProduction()  + " | " +
                "Mileage: " + getMileage()  + " | " +
                "STATUS: " + getVehicleStatus();
    }
}
