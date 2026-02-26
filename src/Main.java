
import services.CustomerService;
import services.EmployeeService;



public class Main {
    public static void main(String[] args) {
        CustomerService customerService = new CustomerService();
        EmployeeService employeeService = new EmployeeService();


//        customerService.printAllCustomers();
        employeeService.printAllEmployee();
    }
}