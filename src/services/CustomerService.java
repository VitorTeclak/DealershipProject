package services;

import DAO.CustomerDAO;
import Entities.Customer;

import java.util.List;

public class CustomerService {
    public void printAllCustomers() {
        CustomerDAO dao = new CustomerDAO();

        List<Customer> customers = dao.findAllCustomers();

        for (Customer customer : customers) {
            System.out.println(customer);
        }
    }
}
