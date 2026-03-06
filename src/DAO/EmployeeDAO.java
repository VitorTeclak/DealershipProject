package DAO;

import Entities.Employee;
import Entities.enums.JobTitle;
import db.DB;

import java.sql.*;
import java.time.LocalDate;
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
    public void addNewEmployee(String name, String cpf, String rg, LocalDate dataOfBirth, String address, String cep, String email, String telefone, JobTitle jobTitle, String accessLevel) {
        String sql = "INSERT INTO EMPLOYEE (name, cpf, rg, date_of_birth, address, cep, email, telefone, job_title, access_level)"
                + "values (?,?,?,?,?,?,?,?,?,?)";

        try (Connection conn = DB.getConnection();
            PreparedStatement st = conn.prepareStatement(sql)) {

            st.setString(1, name);
            st.setString(2, cpf);
            st.setString(3, rg);
            st.setDate(4, Date.valueOf(dataOfBirth));
            st.setString(5, address);
            st.setString(6, cep);
            st.setString(7, email);
            st.setString(8, telefone);
            st.setString(9, jobTitle.name());
            st.setString(10, accessLevel);

            int rowsAffected = st.executeUpdate();

            if (rowsAffected > 0 ) {
                System.out.println("Employee added successfully");
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    public void removeEmployee (String employeeId) {
        String sql = "DELETE FROM employee where employee_id = ?";

        try (Connection conn = DB.getConnection();
            PreparedStatement st = conn.prepareStatement(sql)) {

            st.setString(1, employeeId);

            int rowsAffected = st.executeUpdate();

            if (rowsAffected > 0) {
                System.out.println("Employee removed successfully");
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
