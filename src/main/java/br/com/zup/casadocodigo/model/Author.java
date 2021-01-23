package br.com.zup.casadocodigo.model;

import br.com.zup.casadocodigo.dto.AuthorDto;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.Objects;
import java.util.StringJoiner;

@Entity
@Table(name = "autores")
public class Author {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false, unique = true)
    private String email;

    @Column(nullable = false)
    private String description;

    private final LocalDateTime createdAt = LocalDateTime.now();

    public Author(String name, String email, String description) {
        this.name = name;
        this.email = email;
        this.description = description;
    }

    public Author() { }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public String getDescription() {
        return description;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", Author.class.getSimpleName() + "[", "]")
                .add("Nome: '" + name + "'")
                .add("E-mail: '" + email + "'")
                .add("Descrição: '" + description + "'")
                .add("CriadoEm: " + createdAt)
                .toString();
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((name == null) ? 0 : name.hashCode());
        result = prime * result + ((email == null) ? 0 : email.hashCode());
        result = prime * result + ((description == null) ? 0 : description.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof Author)) {
            return false;
        }
        Author other = (Author) obj;
        return (Objects.equals(name, other.name))
                && (Objects.equals(email, other.email))
                && (Objects.equals(description, other.description));
    }

    public AuthorDto toAuthorDto() {
        return new AuthorDto(name, email, description, createdAt);
    }
}
