package Entities;

import Entities.enums.JobTitle;

import java.time.LocalDate;

public class Employee extends Person{
    private int employeeId;
    private JobTitle jobTitle;
    private int accessLevel ;

    public Employee() {

    }


    public Employee(String name, String cpf, String rg, LocalDate dataOfBirth, String address, String cep, String email, String telefone, JobTitle jobTitle, int accessLevel) {
        super(name, cpf, rg, dataOfBirth, address, cep, email, telefone);
        this.jobTitle = jobTitle;
        this.accessLevel = accessLevel;
    }

    public int getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(int employeeId) {
        this.employeeId = employeeId;
    }

    public JobTitle getAccessLevel() {
        return jobTitle;
    }

    public void setAccessLevel(int accessLevel) {
        this.accessLevel = accessLevel;
    }

    public JobTitle getJobTitle() {
        return jobTitle;
    }

    public void setJobTitle(JobTitle jobTitle) {
        this.jobTitle = jobTitle;
    }

    @Override
    public String toString() {
        return "Employee ID: " + employeeId + " | " +
                "name: " + getName() + " | " +
                "CPF: " + getCpf() + " | " +
                "RG: " + getRg() + " | " +
                "Date of Birth: " + getDataOfBirth() + " | " +
                "Address: " + getAddress() + " | " +
                "CEP: " + getCep() + " | " +
                "Email: " + getEmail() + " | " +
                "Telefone: " + getTelefone() + " | " +
                "Job Title: " + getJobTitle();
    }
}