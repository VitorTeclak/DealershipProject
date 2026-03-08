package DAO;

import Entities.Rental;
import db.DB;

import java.math.BigDecimal;
import java.sql.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class RentalDAO {
    public List<Rental> findAllRentals() {
        List<Rental> rentals = new ArrayList<>();

        String sql = "SELECT * FROM vw_contracts_details";

        try (Connection conn = DB.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {

            while (rs.next()) {
                Rental rental = new Rental();

                rental.setRentalId(rs.getInt("contract_id"));
                rental.setCustomerName(rs.getString("customer_name"));
                rental.setEmployeeName(rs.getString("employee_name"));
                rental.setVehicleName(rs.getString("vehicle_name"));
                rental.setDateOfCollect(rs.getDate("date_of_collect"));
                rental.setDateOfReturn(rs.getDate("date_of_return"));
                rental.setRentalValue(rs.getBigDecimal("rental_value"));

                rentals.add(rental);
            }
        }
        catch (SQLException e) {
            throw new RuntimeException("Error when searching for rentals");
        }
        return rentals;
    }
    public void addNewRental (String customerId, String employeeId, String vehicleId, LocalDate dateOfCollect, LocalDate dateOfReturn, BigDecimal rentalValue) {
        String sql = "INSERT INTO contracts (customer_id, employee_id, vehicle_id, date_of_collect, date_of_return, rental_value)"
                + "VALUES (?,?,?,?,?,?)";

        try (Connection conn = DB.getConnection();
            PreparedStatement st = conn.prepareStatement(sql)) {

            st.setString(1, customerId);
            st.setString(2, employeeId);
            st.setString(3, vehicleId);
            st.setDate(4, Date.valueOf(dateOfCollect));
            st.setDate(5, Date.valueOf(dateOfReturn));
            st.setBigDecimal(6, rentalValue);

            int rowsAffected = st.executeUpdate();

            if (rowsAffected > 0) {
                System.out.println("New contract successfully added !");
            }
        }
        catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    public void editRental (String column, String newValue, String contractId) {
        String sql = "UPDATE contracts SET " + column +" = ? where contract_id = ?";

        try (Connection conn = DB.getConnection();
            PreparedStatement st = conn.prepareStatement(sql)) {

            st.setString(1, newValue);
            st.setString(2, contractId);

            int rowsAffected = st.executeUpdate();

            if (rowsAffected > 0) {
                System.out.println("Contract edited successfully !");
            }
        }
        catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
