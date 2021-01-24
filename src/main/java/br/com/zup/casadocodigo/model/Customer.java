package br.com.zup.casadocodigo.model;

import javax.persistence.*;
import java.util.Objects;
import java.util.StringJoiner;

@Entity
@Table(name = "clientes")
public class Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true)
    private String email;

    @Column(nullable = false)
    private String firstName;

    @Column(nullable = false)
    private String lastName;

    @Column(nullable = false, unique = true)
    private String document;

    @Column(nullable = false)
    private String address;

    @Column(nullable = false)
    private String complement;

    @Column(nullable = false)
    private String city;

    @OneToOne
    private Country country;

    @OneToOne
    private State state;

    @Column(nullable = false)
    private String phone;

    @Column(nullable = false)
    private String zip;

    public Customer() {
    }

    public Customer(String email,
                    String firstName,
                    String lastName,
                    String document,
                    String address,
                    String complement,
                    String city,
                    Country country,
                    State state,
                    String phone,
                    String zip) {

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

    public Country getCountry() {
        return country;
    }

    public State getState() {
        return state;
    }

    public String getPhone() {
        return phone;
    }

    public String getZip() {
        return zip;
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", Customer.class.getSimpleName() + "[", "]")
                .add("Id: '" + id + "'")
                .add("E-mail: '" + email + "'")
                .add("Nome: '" + firstName + "'")
                .add("Sobrenome: '" + lastName + "'")
                .add("Documento: '" + document + "'")
                .add("Endereço: '" + address + "'")
                .add("Complemento: '" + complement + "'")
                .add("Cidade: '" + city + "'")
                .add("País: '" + country + "'")
                .add("Estado: '" + (state == null ? "Sem estado" : state) + "'")
                .add("Telefone: " + phone)
                .add("CEP: " + zip)
                .toString();
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((id == null) ? 0 : id.hashCode());
        result = prime * result + ((email == null) ? 0 : email.hashCode());
        result = prime * result + ((firstName == null) ? 0 : firstName.hashCode());
        result = prime * result + ((lastName == null) ? 0 : lastName.hashCode());
        result = prime * result + ((document == null) ? 0 : document.hashCode());
        result = prime * result + ((address == null) ? 0 : address.hashCode());
        result = prime * result + ((complement == null) ? 0 : complement.hashCode());
        result = prime * result + ((city == null) ? 0 : city.hashCode());
        result = prime * result + ((country == null) ? 0 : country.hashCode());
        result = prime * result + ((phone == null) ? 0 : phone.hashCode());
        result = prime * result + ((zip == null) ? 0 : zip.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof Customer)) {
            return false;
        }
        Customer other = (Customer) obj;
        return (Objects.equals(email, other.getEmail()))
                && (Objects.equals(firstName, other.getFirstName()))
                && (Objects.equals(lastName, other.getLastName()))
                && (Objects.equals(document, other.getDocument()))
                && (Objects.equals(address, other.getAddress()))
                && (Objects.equals(complement, other.getComplement()))
                && (Objects.equals(city, other.getCity()))
                && (Objects.equals(country, other.getCountry()))
                && (Objects.equals(phone, other.getPhone()))
                && (Objects.equals(zip, other.getZip()));
    }
}
