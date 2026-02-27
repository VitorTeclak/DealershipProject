package DAO;

import Entities.Vehicle;
import Entities.enums.VehicleStatus;
import db.DB;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class VehicleDAO {
    public List<Vehicle> findAllVehicles() {
        List<Vehicle> vehicles = new ArrayList<>();

        String sql = "SELECT * FROM vehicle";

        try (Connection conn = DB.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {

            while (rs.next()) {
                Vehicle vehicle = new Vehicle();

                vehicle.setVehicle_id(rs.getInt("vehicle_id"));
                vehicle.setModel(rs.getString("model"));
                vehicle.setColor(rs.getString("color"));
                vehicle.setPrice(rs.getBigDecimal("value"));
                vehicle.setYearOfProduction(rs.getInt("year_of_production"));
                vehicle.setMileage(rs.getInt("mileage"));
                vehicle.setVehicleStatus(VehicleStatus.valueOf(rs.getString("status")));

                vehicles.add(vehicle);
            }
        }
        catch (SQLException e) {
            throw new RuntimeException("Error when searching for vehicles");
        }
        return vehicles;
    }
}
