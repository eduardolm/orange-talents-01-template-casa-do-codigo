package br.com.zup.casadocodigo.dto;

import br.com.zup.casadocodigo.model.Author;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.time.LocalDateTime;

public class AuthorDto {

    @NotBlank(message = "O campo nome é obrigatório.")
    @Size(min = 3, max = 50)
    private String name;

    @NotBlank(message = "O campo e-mail é obrigatório.")
    @Size(min = 11, max = 50)
    @Email
    private String email;

    @NotBlank(message = "O campo descrição é obrigatório.")
    @Size(min = 5, max = 400)
    private String description;
    private LocalDateTime createdAt;

    public AuthorDto(@NotBlank(message = "O campo nome é obrigatório.")
                     @Size(min = 3, max = 50) String name,
                     @NotBlank(message = "O campo e-mail é obrigatório.")
                     @Size(min = 11, max = 50)
                     @Email(message = "Formato inválido.") String email,
                     @NotBlank(message = "O campo descrição é obrigatório.")
                     @Size(min = 5, max = 400) String description,
                     LocalDateTime createdAt) {

        this.name = name;
        this.email = email;
        this.description = description;
        this.createdAt = createdAt;
    }

    public AuthorDto(Author author) {
        this.name = author.getName();
        this.email = author.getEmail();
        this.description = author.getDescription();
        this.createdAt = author.getCreatedAt();
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

    public Author toAuthor() {
        return new Author(name, email, description);
    }
}
