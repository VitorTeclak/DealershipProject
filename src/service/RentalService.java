package service;

import DAO.VehicleDAO;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public class RentalService {
    public void validateDates(LocalDate dateOfCollect, LocalDate dateOfReturn) {
        if (dateOfReturn.isBefore(dateOfCollect)) {
            throw new IllegalArgumentException("Invalid return date");
        }
    }
    public long countRentalDays (LocalDate dateOfCollect, LocalDate dateOfReturn) {
        return ChronoUnit.DAYS.between(dateOfCollect, dateOfReturn) + 1;
    }
    public BigDecimal calculateTheRentalValue (long totalDays, BigDecimal valueVehicle) {
        return valueVehicle
                .multiply(BigDecimal.valueOf(0.002))
                .multiply(BigDecimal.valueOf(totalDays));
    }

}
