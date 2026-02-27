package DAO;

import Entities.Rental;
import db.DB;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
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
}
