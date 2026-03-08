package controller;

import DAO.EmployeeDAO;
import Entities.Employee;
import Entities.enums.JobTitle;

import java.time.LocalDate;
import java.util.List;
import java.util.Scanner;

public class EmployeeController {
    EmployeeDAO dao = new EmployeeDAO();
    public void printAllEmployee() {
        List<Employee> employees= dao.findAllEmployees();

        for (Employee employee : employees) {
            System.out.println(employee);
        }
    }
    public void retrievesDataToInsertNewEmployee (Scanner sc) {

        try {
            System.out.println("Enter name of Employee: ");
            String name = sc.nextLine();
            System.out.println("Enter CPF: ");
            String cpf = sc.nextLine();
            String rg = sc.nextLine();
            System.out.println("Enter date of birth (yyyy-mm-dd): ");
            String date = sc.nextLine();
            LocalDate dateOfBirth = LocalDate.parse(date);
            System.out.println("Enter address: ");
            String address = sc.nextLine();
            System.out.println("Enter cep: ");
            String cep = sc.nextLine();
            System.out.println("Enter email:");
            String email = sc.nextLine();
            System.out.println("Enter telefone: ");
            String telefone = sc.nextLine();
            System.out.println("Enter Job title (SELLER, HR, MECHANIC, MANAGER): ");
            JobTitle jobTitle = JobTitle.valueOf(sc.nextLine().toUpperCase());
            String accessLevel = jobTitle.getAccessLevel();

            dao.addNewEmployee(name, cpf, rg, dateOfBirth, address, cep, email, telefone, jobTitle, accessLevel);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
    public void getEmployeeIdToRemove (Scanner sc) {
        printAllEmployee();
        System.out.println("Enter employee ID to remove: ");
        String employeeId = sc.nextLine();
        dao.removeEmployee(employeeId);
    }
    public void getDataToEditEmployee(Scanner sc) {
        printAllEmployee();
        System.out.println("Enter Employee ID to edit: ");
        String customerId = sc.nextLine();
        System.out.println("VALID COLUMNS");
        System.out.println("NAME | CPF | RG | DATE OF BIRTH | ADDRESS | CEP | EMAIL | TELEFONE | JOB TITLE");
        System.out.println("Enter the column you want to edit: ");
        String column = sc.nextLine().toUpperCase();
        System.out.println("Enter the new value");
        String newValue = sc.nextLine();
        System.out.println(column + newValue + customerId);

        dao.editEmployee(column, newValue, customerId);
    }
}
