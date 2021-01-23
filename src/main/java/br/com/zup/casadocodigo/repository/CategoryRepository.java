package br.com.zup.casadocodigo.repository;

import br.com.zup.casadocodigo.model.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<Category, Long> {
}
