package DAO;

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
}



