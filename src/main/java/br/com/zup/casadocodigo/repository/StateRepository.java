package br.com.zup.casadocodigo.repository;

import br.com.zup.casadocodigo.model.State;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StateRepository extends JpaRepository<State, Long> {
    boolean existsStateByName(String name);
}
