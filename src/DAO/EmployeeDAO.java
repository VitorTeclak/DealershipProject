package DAO;

import Entities.Employee;
import Entities.enums.JobTitle;
import db.DB;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class EmployeeDAO {
    public List<Employee> findAllEmployees() {
        List<Employee> employees = new ArrayList<>();

        String sql = "SELECT * FROM employee";

        try (Connection conn = DB.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {

                 while (rs.next()) {

                     Employee employee = new Employee();

                     employee.setEmployeeId(rs.getInt("employee_id"));
                     employee.setName(rs.getString("name"));
                     employee.setCpf(rs.getString("cpf"));
                     employee.setRg(rs.getString("rg"));
                     employee.setDataOfBirth(rs.getDate("date_of_birth").toLocalDate());
                     employee.setAddress(rs.getString("address"));
                     employee.setCep(rs.getString("cep"));
                     employee.setEmail(rs.getString("email"));
                     employee.setTelefone(rs.getString("telefone"));
                     employee.setAccessLevel(rs.getInt("access_level"));
                     employee.setJobTitle(JobTitle.valueOf(rs.getString("job_title")));

                     employees.add(employee);

                 }
        }
        catch (SQLException e) {
            throw new RuntimeException("error when searching for customers", e);
        }
        return employees;
    }
}
