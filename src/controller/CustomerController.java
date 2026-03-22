package controller;

import DAO.CustomerDAO;
import Entities.Customer;
import service.CustomerService;

import java.time.LocalDate;

import java.util.List;
import java.util.Scanner;

public class CustomerController {
    CustomerDAO dao = new CustomerDAO();
    CustomerService customerService = new CustomerService();



    public void printAllCustomers() {


        List<Customer> customers = dao.findAllCustomers();

        for (Customer customer : customers) {
            System.out.println(customer);
        }
    }
    public void retrievesDataToInsertNewCustomer(Scanner sc) {

        try {
            System.out.println("Enter name of Customer: ");
            String name = sc.nextLine();
            System.out.println("Enter CPF: ");
            String cpf = sc.nextLine();
            customerService.validateCpf(cpf);
            System.out.println("Enter RG: ");
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

            dao.addNewCustomer(name, cpf, rg, dateOfBirth, address, cep, email, telefone);

        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
    public void getCustomerIdToRemove(Scanner sc) {
        printAllCustomers();
        System.out.println("Enter Customer ID to remove: ");
        String customerId = sc.nextLine();
        dao.removeCustomer(customerId);
    }
    public void getDataToEditCustomer(Scanner sc) {
        printAllCustomers();
        System.out.println("Enter Customer ID to edit: ");
        String customerId = sc.nextLine();
        System.out.println("VALID COLUMNS");
        System.out.println("NAME | CPF | RG | DATE OF BIRTH | ADDRESS | CEP | EMAIL | TELEFONE");
        System.out.println("Enter the column you want to edit: ");
        String column = sc.nextLine().toUpperCase();
        System.out.println("Enter the new value");
        String newValue = sc.nextLine();
        System.out.println(column + newValue + customerId);

        dao.editCustomer(column, newValue, customerId);
    }

}
