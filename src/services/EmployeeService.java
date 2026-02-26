package services;

import DAO.EmployeeDAO;
import Entities.Employee;

import java.util.List;

public class EmployeeService {
    public void printAllEmployee() {
        EmployeeDAO dao = new EmployeeDAO();

        List<Employee> employees= dao.findAllEmployees();

        for (Employee employee : employees) {
            System.out.println(employee);
        }
    }
}
