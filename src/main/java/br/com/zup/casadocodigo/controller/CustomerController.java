package br.com.zup.casadocodigo.controller;

import br.com.zup.casadocodigo.controller.request.CustomerRequestDto;
import br.com.zup.casadocodigo.dto.CustomerDto;
import br.com.zup.casadocodigo.exception.CustomerConversionException;
import br.com.zup.casadocodigo.repository.CountryRepository;
import br.com.zup.casadocodigo.repository.CustomerRepository;
import br.com.zup.casadocodigo.repository.StateRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping("/api/v1/customers")
public class CustomerController {

    @Autowired
    private StateRepository stateRepository;

    @Autowired
    private CountryRepository countryRepository;

    @Autowired
    private CustomerRepository customerRepository;

    @PostMapping
    public ResponseEntity<CustomerDto> create(@RequestBody @Valid CustomerRequestDto customerRequestDto)
            throws CustomerConversionException {

        if (!customerRepository.existsCustomerByEmail(customerRequestDto.getEmail())) {
            return ResponseEntity
                    .ok(new CustomerDto(customerRepository
                            .save(customerRequestDto.convertCustomerRequestDtoToCustomer(countryRepository,
                                    stateRepository))));
        }
        return ResponseEntity.badRequest().build();
    }
}
