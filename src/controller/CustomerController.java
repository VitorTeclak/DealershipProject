package controller;

import DAO.CustomerDAO;
import Entities.Customer;

import java.util.List;

public class CustomerController {
    public void printAllCustomers() {
        CustomerDAO dao = new CustomerDAO();

        List<Customer> customers = dao.findAllCustomers();

        for (Customer customer : customers) {
            System.out.println(customer);
        }
    }
}
