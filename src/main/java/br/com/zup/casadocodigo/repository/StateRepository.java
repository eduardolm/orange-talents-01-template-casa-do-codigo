package br.com.zup.casadocodigo.repository;

import br.com.zup.casadocodigo.model.State;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface StateRepository extends JpaRepository<State, Long> {
    boolean existsStateByName(String name);

    Optional<State> findStateByName(String state);
}
