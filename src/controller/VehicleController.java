package controller;

import DAO.VehicleDAO;
import Entities.Vehicle;

import java.util.List;

public class VehicleController {
    public void printAllVehicles() {
        VehicleDAO dao = new VehicleDAO();

        List<Vehicle> vehicles = dao.findAllVehicles();

        for (Vehicle vehicle : vehicles) {
            System.out.println(vehicle);
        }
    }
}
