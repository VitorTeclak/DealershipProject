package controller;

import DAO.EmployeeDAO;
import Entities.Employee;

import java.util.List;

public class EmployeeController {
    public void printAllEmployee() {
        EmployeeDAO dao = new EmployeeDAO();

        List<Employee> employees= dao.findAllEmployees();

        for (Employee employee : employees) {
            System.out.println(employee);
        }
    }
}
