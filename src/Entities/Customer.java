package Entities;

import java.time.LocalDate;

public class Customer extends Person{
    private  int customerId;

    public Customer() {
    }

    public Customer(int customerId, String name, String cpf, String rg, LocalDate dataOfBirth, String address, String cep, String email, String telefone) {
        super(name, cpf, rg, dataOfBirth, address, cep, email, telefone);
        this.customerId = customerId;
    }
    public int getCustomerId() {
        return customerId;
    }

    public void setCustomerId(int customerId) {
        this.customerId = customerId;
    }

    @Override
    public String toString() {
        return "Customer ID: " + customerId + " | " +
                "name: " + getName() + " | " +
                "CPF: " + getCpf() + " | " +
                "RG: " + getRg() + " | " +
                "Date of Birth: " + getDataOfBirth() + " | " +
                "Address: " + getAddress() + " | " +
                "CEP: " + getCep() + " | " +
                "Email: " + getEmail() + " | " +
                "Telefone: " + getTelefone();

    }
}
