package controller;

import DAO.RentalDAO;
import Entities.Rental;

import java.util.List;

public class RentalController {
    public void printAllRentals() {
        RentalDAO dao = new RentalDAO();

        List<Rental> rentals = dao.findAllRentals();

        for (Rental rental : rentals) {
            System.out.println(rental);
        }
    }
}
