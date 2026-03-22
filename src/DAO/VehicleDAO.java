package DAO;

import Entities.Vehicle;
import Entities.enums.VehicleStatus;
import db.DB;

import java.math.BigDecimal;
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
    public void addNewVehicle (String model, String color, BigDecimal price, int year, Integer mileage, VehicleStatus vehicleStatus) {
        String sql ="INSERT INTO vehicle (model, color, value, year_of_production, mileage, status)"
                + "VALUES (?,?,?,?,?,?)";

        try (Connection conn = DB.getConnection();
            PreparedStatement st = conn.prepareStatement(sql)) {
            st.setString(1, model);
            st.setString(2, color);
            st.setBigDecimal(3, price);
            st.setInt(4, year);
            st.setInt(5, mileage);
            st.setString(6, vehicleStatus.name());

            int rowsAffected = st.executeUpdate();

            if (rowsAffected > 0) {
                System.out.println("Vehicle added successfully !");
            }
        }
        catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    public void removeVehicle (String vehicleId) {
        String sql ="DELETE FROM vehicle WHERE vehicle_id = ?";

        try (Connection conn = DB.getConnection();
            PreparedStatement st = conn.prepareStatement(sql)) {
            st.setString(1, vehicleId);

            int rowsAffected = st.executeUpdate();

            if (rowsAffected > 0) {
                System.out.println("Vehicle removed successfully !");
            }
        }
        catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    public void editVehicle(String column, String newValue, String vehicleId) {
        String sql="UPDATE vehicle SET " + column + " = ? where vehicle_id = ?";

        try (Connection conn = DB.getConnection();
            PreparedStatement st = conn.prepareStatement(sql)) {

            st.setString(1, newValue);
            st.setString(2, vehicleId);

            int rowsAffected = st.executeUpdate();

            if (rowsAffected > 0) {
                System.out.println("Vehicle edited successfully !");
            }
        }
        catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    public BigDecimal getVehicleValue (String vehicleId) {
        String sql = "SELECT value FROM vehicle WHERE vehicle_id = ?";

        try (Connection conn = DB.getConnection();
             PreparedStatement st = conn.prepareStatement(sql)) {

            st.setString(1, vehicleId);

            try (ResultSet rs = st.executeQuery()) {

                if (rs.next()) {
                    return rs.getBigDecimal("value");
                } else {
                    throw new RuntimeException("Vehicle not found");
                }
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}

