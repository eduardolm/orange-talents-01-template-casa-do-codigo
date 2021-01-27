package br.com.zup.casadocodigo.repository;

import br.com.zup.casadocodigo.model.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Long> {

    boolean existsCustomerByEmail(String email);
}
