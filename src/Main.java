import Entities.Customer;
import DAO.CustomerDAO;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        CustomerDAO dao = new CustomerDAO();

        List<Customer> customers = dao.findAllCustomers();

        for (Customer customer : customers) {
            System.out.println(customer);
        }
    }
}