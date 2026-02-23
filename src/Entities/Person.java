package Entities;

import java.time.LocalDate;

public class Person {
    private String name;
    private String cpf;
    private String rg;
    private LocalDate dataOfBirth;
    private String address;
    private String cep;
    private String email;
    private String telefone;

    public Person() {
    }

    public Person(String name, String cpf, String rg, LocalDate dataOfBirth, String address, String cep, String email, String telefone) {
        this.name = name;
        this.cpf = cpf;
        this.rg = rg;
        this.dataOfBirth = dataOfBirth;
        this.address = address;
        this.cep = cep;
        this.email = email;
        this.telefone = telefone;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getRg() {
        return rg;
    }

    public void setRg(String rg) {
        this.rg = rg;
    }

    public LocalDate getDataOfBirth () {
        return dataOfBirth;
    }

    public void setDataOfBirth(LocalDate dataOfBirth) {
        this.dataOfBirth = dataOfBirth;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }
}