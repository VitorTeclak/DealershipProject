

import controller.CustomerController;
import controller.EmployeeController;
import controller.RentalController;
import controller.VehicleController;
import java.util.Scanner;


public class Main {
    private static void waitEnter(Scanner sc) {
        System.out.println("\nPress ENTER to return to menu...");
        sc.nextLine();
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        CustomerController customerController = new CustomerController();
        EmployeeController employeeController = new EmployeeController();
        VehicleController vehicleController = new VehicleController();
        RentalController rentalController = new RentalController();





//
//
//
//
//

//
//
//
//
//
//
//

        while (true) {
            System.out.println("1. Show all customers");
            System.out.println("2. Add new customer");
            System.out.println("3. Edit customer");
            System.out.println("4. Remove Customer");
            System.out.println("5. Show all employee");
            System.out.println("6. Add new employee");
            System.out.println("7. Edit employee");
            System.out.println("8. Remove employee");
            System.out.println("9. Show all vehicles");
            System.out.println("10. Add new vehicle");
            System.out.println("11. Edit vehicle");
            System.out.println("12. Remove vehicle");
            System.out.println("13. Show all rental");
            System.out.println("14. Add new rental");
            System.out.println("15. Edit rental");
            System.out.println(" ");
            System.out.println("Select the desirable option: ");
            String choice = sc.nextLine();

            switch (choice) {
                case "1": customerController.printAllCustomers();
                waitEnter(sc);
                break;

                case "2" : customerController.retrievesDataToInsertNewCustomer(sc);
                waitEnter(sc);
                break;

                case "3": customerController.getDataToEditCustomer(sc);
                waitEnter(sc);
                break;

                case "4" : customerController.getCustomerIdToRemove(sc);
                waitEnter(sc);
                break;

                case "5" : employeeController.printAllEmployee();
                waitEnter(sc);
                break;

                case "6" : employeeController.retrievesDataToInsertNewEmployee(sc);
                waitEnter(sc);
                break;

                case "7": employeeController.getDataToEditEmployee(sc);
                waitEnter(sc);
                break;

                case "8": employeeController.getEmployeeIdToRemove(sc);
                waitEnter(sc);
                break;

                case "9": vehicleController.printAllVehicles();
                waitEnter(sc);
                break;

                case "10": vehicleController.retrievesDataToInsertNewVehicle(sc);
                waitEnter(sc);
                break;

                case "11": vehicleController.getDataToEditVehicle(sc);
                waitEnter(sc);
                break;

                case "12": vehicleController.getVehicleIdToRemove(sc);
                waitEnter(sc);
                break;

                case "13": rentalController.printAllRentals();
                waitEnter(sc);
                break;

                case "14": rentalController.retrievesDataToInsertNewContract(sc);
                waitEnter(sc);
                break;

                case "15": rentalController.getDataToEditContract(sc);
                waitEnter(sc);
                break;

                default:
                    System.out.println("Choose a valid option");
            }

        }

    }

}