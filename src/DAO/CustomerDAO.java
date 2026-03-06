package DAO;


import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import Entities.Customer;
import db.DB;
import java.sql.*;

public class CustomerDAO {
    public List<Customer> findAllCustomers() {
        List<Customer> customers = new ArrayList<>();

        String sql = "SELECT * FROM customer";

        try (Connection conn = DB.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {

            while (rs.next()) {
                Customer customer = new Customer();

                customer.setCustomerId(rs.getInt("customer_id"));
                customer.setName(rs.getString("name"));
                customer.setCpf(rs.getString("cpf"));
                customer.setRg(rs.getString("rg"));
                customer.setDataOfBirth(rs.getDate("date_of_birth").toLocalDate());
                customer.setAddress(rs.getString("address"));
                customer.setCep(rs.getString("cep"));
                customer.setEmail(rs.getString("email"));
                customer.setTelefone(rs.getString("telefone"));

                customers.add(customer);
            }

        } catch (SQLException e) {
            throw new RuntimeException("error when searching for customers", e);
        }
        return customers;
    }
    public void addNewCustomer (String name, String cpf, String rg, LocalDate dateOfBirth, String address, String cep, String email, String telefone) {
            String sql = "INSERT INTO customer (name, cpf, rg, date_of_birth, address, cep, email, telefone) "
                    + "values (?, ?, ?, ?, ?, ?, ?, ?)";

        try (Connection conn = DB.getConnection();
             PreparedStatement st = conn.prepareStatement(sql)) {

            st.setString(1, name);
            st.setString(2, cpf);
            st.setString(3, rg);
            st.setDate(4, Date.valueOf(dateOfBirth));
            st.setString(5, address);
            st.setString(6, cep);
            st.setString(7, email);
            st.setString(8, telefone);

            int rowsAffected = st.executeUpdate();

            if (rowsAffected > 0) {
                System.out.println("Customer added successfully !");
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    public void removeCustomer(String customerId) {

        String sql = "DELETE FROM customer where customer_id = ?";


        try (Connection conn = DB.getConnection();
             PreparedStatement st = conn.prepareStatement(sql)){

            st.setString(1, customerId);

            int rowsAffected = st.executeUpdate();

            if (rowsAffected > 0) {
                System.out.println("Customer removed successfully !");
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    public void editCustomer(String column, String newValue, String customerId) {
        String sql = "UPDATE customer SET " + column + " = ? WHERE customer_id = ?";
        try (Connection conn = DB.getConnection();
             PreparedStatement st = conn.prepareStatement(sql)) {
            st.setString(1, newValue);
            st.setString(2, customerId);

            int rowsAffected = st.executeUpdate();

            if (rowsAffected > 0) {
                System.out.println("Customer edited successfully !");
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}



