package br.com.zup.casadocodigo.controller.request;

import br.com.zup.casadocodigo.exception.CustomerConversionException;
import br.com.zup.casadocodigo.model.Country;
import br.com.zup.casadocodigo.model.Customer;
import br.com.zup.casadocodigo.model.State;
import br.com.zup.casadocodigo.repository.CountryRepository;
import br.com.zup.casadocodigo.repository.StateRepository;
import br.com.zup.casadocodigo.validator.CEP;
import br.com.zup.casadocodigo.validator.CPFeCNPJ;
import br.com.zup.casadocodigo.validator.UniqueValue;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.util.NoSuchElementException;
import java.util.Optional;

public class CustomerRequestDto {

    private Long id;

    @NotBlank(message = "E-mail é obrigatório.")
    @Size(min = 10, max = 50, message = "O e-mail deve ter entre 10 e 50 caracteres.")
    @Email(message = "Formato inválido.")
    @UniqueValue(domainClass = Customer.class, fieldName = "email", message = "E-mail já cadastrado no sistema.")
    private String email;

    @NotBlank(message = "Nome é obrigatório.")
    @Size(min = 3, max = 50, message = "O nome deve ter entre 3 e 50 caracteres.")
    private String firstName;

    @NotBlank(message = "Sobrenome é obrigatório.")
    @Size(min = 3, max = 50, message = "O sobrenome deve ter entre 3 e 50 caracteres.")
    private String lastName;

    @NotBlank(message = "O documento é obrigatório.")
    @Size(min = 11, max = 14, message = "O documento deve ter 11 caracteres para CPF e 14 caracteres para CNPJ.")
    @UniqueValue(domainClass = Customer.class, fieldName = "document", message = "Documento já cadastrado.")
    @CPFeCNPJ(message = "CPF/CNPJ inválido.")
    private String document;

    @NotBlank(message = "O endereço é obrigatório.")
    private String address;

    @NotBlank(message = "O complemento é obrigatório.")
    private String complement;

    @NotBlank(message = "Obrigatório informar a cidade.")
    private String city;

    @NotBlank(message = "O país é obrigatório.")
    private String country;

    private String state;

    @NotBlank(message = "É obrigatório informar um telefone")
    @Size(min = 10, max = 20, message = "O telefone deve ter entre 10 e 20 caracteres.")
    private String phone;

    @NotBlank(message = "É obrigatório informar o CEP.")
    @CEP(message = "CEP inválido.")
    private String zip;

    public CustomerRequestDto() {
    }

    public CustomerRequestDto(
          Long id,
          @NotBlank(message = "E-mail é obrigatório.")
          @Size(min = 10, max = 50, message = "O e-mail deve ter entre 10 e 50 caracteres.")
          @Email(message = "Formato inválido.") String email,
          @NotBlank(message = "Nome é obrigatório.")
          @Size(min = 3, max = 50, message = "O nome deve ter entre 3 e 50 caracteres.") String firstName,
          @NotBlank(message = "Sobrenome é obrigatório.")
          @Size(min = 3, max = 50, message = "O sobrenome deve ter entre 3 e 50 caracteres.") String lastName,
          @NotBlank(message = "O documento é obrigatório.")
          @Size(min = 11, max = 14, message = "O documento deve ter 11 caracteres para CPF e 14 caracteres para CNPJ.")
                  String document,
          @NotBlank(message = "O endereço é obrigatório.") String address,
          @NotBlank(message = "O complemento é obrigatório.") String complement,
          @NotBlank(message = "Obrigatório informar a cidade.") String city,
          @NotBlank(message = "O país é obrigatório.") String country,
          String state,
          @NotBlank(message = "É obrigatório informar um telefone")
          @Size(min = 10, max = 20, message = "O telefone deve ter entre 10 e 20 caracteres.") String phone,
          @NotBlank(message = "É obrigatório informar o CEP.") String zip) {

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

    public CustomerRequestDto(Customer customer) {
        this.id = customer.getId();
        this.email = customer.getEmail();
        this.firstName = customer.getFirstName();
        this.lastName = customer.getLastName();
        this.document = customer.getDocument();
        this.address = customer.getAddress();
        this.complement = customer.getComplement();
        this.city = customer.getCity();
        this.country = customer.getCountry().getName();
        this.state = customer.getState().getName();
        this.phone = customer.getPhone();
        this.zip = customer.getZip();
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

    public Customer convertCustomerRequestDtoToCustomer(CountryRepository countryRepository,
                                                        StateRepository stateRepository)
            throws NoSuchElementException, CustomerConversionException {

        Optional<Country> tempCountry = countryRepository.findCountryByName(country);
        Optional<State> tempState = stateRepository.findStateByName(state);

        if (tempCountry.isPresent() && tempState.isPresent()) {
            return new Customer(email, firstName, lastName, document, address, complement, city, tempCountry.get(),
                    tempState.get(), phone, zip);
        }
        else {
            throw new CustomerConversionException(tempCountry, tempState);
        }
    }
}
