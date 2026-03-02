
import controller.CustomerController;
import controller.EmployeeController;
import controller.RentalController;
import controller.VehicleController;

import java.util.Scanner;


public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        CustomerController customerController = new CustomerController();
        EmployeeController employeeController = new EmployeeController();
        VehicleController vehicleController = new VehicleController();
        RentalController rentalController = new RentalController();


//        customerService.printAllCustomers();
//        employeeController.printAllEmployee();
//        vehicleController.printAllVehicles();
//        rentalController.printAllRentals();
//        customerController.retrievesDataToInsertNewCustomer(sc);
        customerController.getCustomerIdToRemove(sc);
    }

}