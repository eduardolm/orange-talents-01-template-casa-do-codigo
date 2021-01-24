package br.com.zup.casadocodigo.model;

import br.com.zup.casadocodigo.dto.CategoryDto;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "categorias")
public class Category {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true)
    private String name;

    @OneToMany(mappedBy = "category")
    private List<Book> books;

    public Category(String name) {
        this.name = name;
    }

    public Category() { }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public CategoryDto toCategoryDto() {
        return new CategoryDto(name);
    }
}
