package controller;

import DAO.RentalDAO;
import DAO.VehicleDAO;
import Entities.Rental;
import service.RentalService;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;
import java.util.Scanner;


public class RentalController {
    RentalDAO dao = new RentalDAO();
    RentalService rentalService = new RentalService();
    CustomerController customerController = new CustomerController();
    EmployeeController employeeController = new EmployeeController();
    VehicleController vehicleController = new VehicleController();
    VehicleDAO vehicleDAO = new VehicleDAO();
    public void printAllRentals() {
        List<Rental> rentals = dao.findAllRentals();

        for (Rental rental : rentals) {
            System.out.println(rental);
        }
    }
    public void retrievesDataToInsertNewContract(Scanner sc) {
        try {
            customerController.printAllCustomers();
            System.out.println("Enter customer ID: ");
            String customerId = sc.nextLine();
            employeeController.printAllEmployee();
            System.out.println("Enter employee ID: ");
            String employeeId = sc.nextLine();
            vehicleController.printAllVehicles();
            System.out.println("Enter vehicle ID: ");
            String vehicleId = sc.nextLine();
            System.out.println("Enter date of collect (yyyy-MM-dd): ");
            String date = sc.nextLine();
            LocalDate dateOfCollect = LocalDate.parse(date);
            System.out.println("Enter date of return (yyyy-MM-dd): ");
            date = sc.nextLine();
            LocalDate dateOfReturn = LocalDate.parse(date);
            BigDecimal price = vehicleDAO.getVehicleValue(vehicleId);
            long totalDays = rentalService.countRentalDays(dateOfCollect, dateOfReturn);
            price = rentalService.calculateTheRentalValue(totalDays, price);
            dao.addNewRental(customerId, employeeId, vehicleId, dateOfCollect, dateOfReturn, price);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
    public void getDataToEditContract(Scanner sc) {
        try {
            printAllRentals();
            System.out.println("Enter the contract ID to edit: ");
            String contractId = sc.nextLine();
            System.out.println("VALID COLUMNS");
            System.out.println("CUSTOMER ID | EMPLOYEE ID | VEHICLE ID | DATE OF COLLECT | DATE OF RETURN | RENTAL PRICE");
            System.out.println("Enter column to edit: ");
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
