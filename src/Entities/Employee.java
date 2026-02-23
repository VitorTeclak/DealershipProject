package Entities;

import Entities.enums.AccessLevel;

import java.awt.*;
import java.time.LocalDate;

public class Employee extends Person{
    private String jobTitle;
    private AccessLevel accessLevel;

    public Employee(String name, String cpf, String rg, LocalDate dataOfBirth, String address, String cep, String email, String telefone, String jobTitle, AccessLevel accessLevel) {
        super(name, cpf, rg, dataOfBirth, address, cep, email, telefone);
        this.jobTitle = jobTitle;
        this.accessLevel = accessLevel;
    }

    public String getJobTitle() {
        return jobTitle;
    }

    public void setPosition(String jobTitle) {
        this.jobTitle = jobTitle;
    }

    public AccessLevel getAccessLevel() {
        return accessLevel;
    }

    public void setAccessLevel(AccessLevel accessLevel) {
        this.accessLevel = accessLevel;
    }
}