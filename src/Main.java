
import controller.CustomerController;
import controller.EmployeeController;
import controller.RentalController;
import controller.VehicleController;


public class Main {
    public static void main(String[] args) {
        CustomerController customerController = new CustomerController();
        EmployeeController employeeController = new EmployeeController();
        VehicleController vehicleController = new VehicleController();
        RentalController rentalController = new RentalController();


//        customerService.printAllCustomers();
//        employeeController.printAllEmployee();
//        vehicleController.printAllVehicles();
        rentalController.printAllRentals();
    }

}