package br.com.zup.casadocodigo.repository;

import br.com.zup.casadocodigo.model.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BookRepository extends JpaRepository<Book, Long> {

    boolean existsBookByTitle(String title);
}
