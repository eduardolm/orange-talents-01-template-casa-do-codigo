package br.com.zup.casadocodigo.controller.request;

import br.com.zup.casadocodigo.dto.CustomerDetailDto;
import br.com.zup.casadocodigo.dto.CustomerDto;
import br.com.zup.casadocodigo.exception.CustomerConversionException;
import br.com.zup.casadocodigo.model.Customer;
import br.com.zup.casadocodigo.repository.CountryRepository;
import br.com.zup.casadocodigo.repository.CustomerRepository;
import br.com.zup.casadocodigo.repository.StateRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.stream.Collectors;

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

    @GetMapping
    public ResponseEntity<List<CustomerDto>> findAll() {
        List<Customer> customers = customerRepository.findAll();
        return ResponseEntity.ok(customers.stream().map(CustomerDto::new).collect(Collectors.toList()));
    }

    @GetMapping("{id}")
    public ResponseEntity<CustomerDetailDto> findById(@PathVariable() Long id) {
        CustomerDetailDto response = new CustomerDetailDto(customerRepository.findById(id).orElseThrow(() ->
                new NoSuchElementException("Cliente nÃo encontrado.")));
        return ResponseEntity.ok(response);
    }
}
