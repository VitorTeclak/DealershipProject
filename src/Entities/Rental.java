package Entities;

import java.math.BigDecimal;
import java.util.Date;

public class Rental {
    private int rentalId;
    private String customerName;
    private String employeeName;
    private String vehicleName;
    private Date dateOfCollect;
    private Date dateOfReturn;
    private BigDecimal rentalValue;

    public Rental() {
    }

    public Rental(int rentalId, String customerName, String employeeName, String vehicleName, Date dateOfCollect, Date dateOfReturn, BigDecimal rentalValue) {
        this.rentalId = rentalId;
        this.customerName = customerName;
        this.employeeName = employeeName;
        this.vehicleName = vehicleName;
        this.dateOfCollect = dateOfCollect;
        this.dateOfReturn = dateOfReturn;
        this.rentalValue = rentalValue;
    }

    public int getRentalId() {
        return rentalId;
    }

    public void setRentalId(int rentalId) {
        this.rentalId = rentalId;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public String getEmployeeName() {
        return employeeName;
    }

    public void setEmployeeName(String employeeName) {
        this.employeeName = employeeName;
    }

    public String getVehicleName() {
        return vehicleName;
    }

    public void setVehicleName(String vehicleName) {
        this.vehicleName = vehicleName;
    }

    public Date getDateOfCollect() {
        return dateOfCollect;
    }

    public void setDateOfCollect(Date dateOfCollect) {
        this.dateOfCollect = dateOfCollect;
    }

    public Date getDateOfReturn() {
        return dateOfReturn;
    }

    public void setDateOfReturn(Date dateOfReturn) {
        this.dateOfReturn = dateOfReturn;
    }

    public BigDecimal getRentalValue() {
        return rentalValue;
    }

    public void setRentalValue(BigDecimal rentalValue) {
        this.rentalValue = rentalValue;
    }

    @Override
    public String toString() {
        return "Contract ID: " + getRentalId() + " | " +
                "Customer Name: " + getCustomerName() + " | " +
                "Employee Name: " + getEmployeeName() + " | " +
                "Vehicle Name: " + getVehicleName() + " | " +
                "Date Of Collect: " + getDateOfCollect() + " | " +
                "Date Of Return: " + getDateOfReturn() + " | " +
                "Rental Value: " + getRentalValue();
    }
}