package service;

import db.DB;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class EmployeeService {
    public void validateCpf(String cpf) {
        String sql = "SELECT 1 FROM employee WHERE cpf = ?";

        try (Connection conn = DB.getConnection();
             PreparedStatement st = conn.prepareStatement(sql)) {

            st.setString(1, cpf);

            try (ResultSet rs = st.executeQuery()) {
                if (rs.next()) {
                    throw new IllegalArgumentException("CPF already exists");
                }
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

}
