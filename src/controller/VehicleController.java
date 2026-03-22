package controller;

import DAO.VehicleDAO;
import Entities.Vehicle;
import Entities.enums.JobTitle;
import Entities.enums.VehicleStatus;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;
import java.util.Scanner;

public class VehicleController {
    VehicleDAO dao = new VehicleDAO();

    public void printAllVehicles() {
        VehicleDAO dao = new VehicleDAO();

        List<Vehicle> vehicles = dao.findAllVehicles();

        for (Vehicle vehicle : vehicles) {
            System.out.println(vehicle);
        }
    }
    public void retrievesDataToInsertNewVehicle(Scanner sc) {
        try {
            System.out.println("Enter model of vehicle: ");
            String model = sc.nextLine();
            System.out.println("Enter color: ");
            String color = sc.nextLine();
            System.out.println("Enter price: ");
            BigDecimal price = sc.nextBigDecimal();
            System.out.println("Enter year of production (yyyy): ");
            int year = sc.nextInt();
            System.out.println("Enter mileage: ");
            Integer mileage = sc.nextInt();
            sc.nextLine();
            System.out.println("Enter car status (AVAILABLE, RENTED, MAINTENANCE:");
            VehicleStatus vehicleStatus = VehicleStatus.valueOf(sc.nextLine().toUpperCase());

            dao.addNewVehicle(model, color, price, year, mileage, vehicleStatus);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
    public void getVehicleIdToRemove(Scanner sc) {
        try {
            printAllVehicles();
            System.out.println("Enter vehicle ID to remove");
            String vehicleId = sc.nextLine();

            dao.removeVehicle(vehicleId);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
    public void getDataToEditVehicle(Scanner sc) {
        try {
            printAllVehicles();
            System.out.println("Enter vehicle ID to edit");
            String vehicleId = sc.nextLine();
            System.out.println("VALID COLUMNS");
            System.out.println("MODEL | COLOR | PRICE | YEAR | MILEAGE | STATUS");
            System.out.println("Enter the column you want to edit: ");
            String columns = sc.nextLine().toUpperCase();
            System.out.println("Enter the new value");
            String newValue = sc.nextLine();

            dao.editVehicle(columns, newValue, vehicleId);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

}
