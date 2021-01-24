package br.com.zup.casadocodigo.repository;

import br.com.zup.casadocodigo.model.Author;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface AuthorRepository extends JpaRepository<Author, Long> {

    boolean existsAuthorByEmail(String email);

    Optional<Author> findAuthorByName(String name);
}
