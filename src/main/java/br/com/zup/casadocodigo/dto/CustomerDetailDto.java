package br.com.zup.casadocodigo.dto;

import br.com.zup.casadocodigo.model.Customer;

public class CustomerDetailDto {

    private Long id;
    private String email;
    private String firstName;
    private String lastName;
    private String document;
    private String address;
    private String complement;
    private String city;
    private String country;
    private String state;
    private String phone;
    private String zip;

    public CustomerDetailDto(Long id,
                             String email,
                             String firstName,
                             String lastName,
                             String document,
                             String address,
                             String complement,
                             String city,
                             String country,
                             String state,
                             String phone,
                             String zip) {

        this.id = id;
        this.email = email;
        this.firstName = firstName;
        this.lastName = lastName;
        this.document = document;
        this.address = address;
        this.complement = complement;
        this.city = city;
        this.country = country;
        this.state = state;
        this.phone = phone;
        this.zip = zip;
    }

    public CustomerDetailDto(Customer customer ) {
        this.id = customer.getId();
        this.email = customer.getEmail();
        this.firstName = customer.getFirstName();
        this.lastName = customer.getLastName();
        this.document = customer.getDocument();
        this.address = customer.getAddress();
        this.complement = customer.getComplement();
        this.city = customer.getCity();
        this.country = customer.getCountry().getName();
        this.state = customer.getState().getName() == null ? "Informação não disponível." : customer.getState().getName();
        this.phone = customer.getPhone();
        this.zip = customer.getZip();
    }

    public CustomerDetailDto() {
    }

    public Long getId() {
        return id;
    }

    public String getEmail() {
        return email;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getDocument() {
        return document;
    }

    public String getAddress() {
        return address;
    }

    public String getComplement() {
        return complement;
    }

    public String getCity() {
        return city;
    }

    public String getCountry() {
        return country;
    }

    public String getState() {
        return state;
    }

    public String getPhone() {
        return phone;
    }

    public String getZip() {
        return zip;
    }
}
