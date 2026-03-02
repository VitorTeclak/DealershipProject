package controller;

import DAO.CustomerDAO;
import Entities.Customer;

import java.time.LocalDate;

import java.util.List;
import java.util.Scanner;

public class CustomerController {
    CustomerDAO dao = new CustomerDAO();
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

}
