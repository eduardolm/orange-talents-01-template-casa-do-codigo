package br.com.zup.casadocodigo.dto;

import br.com.zup.casadocodigo.model.Customer;

public class CustomerDto {

    private Long id;
    private String firstName;
    private String lastName;

    public CustomerDto(Long id, String firstName, String lastName) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public Long getId() {
        return id;
    }

    public CustomerDto(Customer customer) {
        this.id = customer.getId();
        this.firstName = customer.getFirstName();
        this.lastName = customer.getLastName();
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }
}
