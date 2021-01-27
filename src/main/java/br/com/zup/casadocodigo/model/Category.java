package br.com.zup.casadocodigo.model;

import br.com.zup.casadocodigo.dto.CategoryDto;

import javax.persistence.*;
import java.util.List;
import java.util.Objects;

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

    public Long getId() {
        return id;
    }

    public List<Book> getBooks() {
        return books;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public CategoryDto toCategoryDto() {
        return new CategoryDto(name);
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((id == null) ? 0 : id.hashCode());
        result = prime * result + ((name == null) ? 0 : name.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof Category)) {
            return false;
        }
        Category other = (Category) obj;
        return (Objects.equals(id, other.getId()))
                && (Objects.equals(name, other.name))
                && (Objects.equals(books, other.getBooks()));
    }

    @Override
    public String toString() {
        return "Categoria [Id: " + id + ", Nome: " + name + "]";
    }
}
