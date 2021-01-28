package br.com.zup.casadocodigo.dto;

import br.com.zup.casadocodigo.model.Author;
import br.com.zup.casadocodigo.validator.UniqueValue;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class AuthorDto {

    @NotBlank(message = "O campo nome é obrigatório.")
    @Size(min = 3, max = 50)
    private String name;

    @UniqueValue(domainClass = Author.class, fieldName = "email", message = "E-mail já cadastrado em nosso sistema.")
    @NotBlank(message = "O campo e-mail é obrigatório.")
    @Size(min = 11, max = 50)
    @Email
    private String email;

    @NotBlank(message = "O campo descrição é obrigatório.")
    @Size(min = 5, max = 400)
    private String description;
    private LocalDateTime createdAt;
    private List<BookDetailDto> books;

    public AuthorDto() {
    }

    public AuthorDto(@NotBlank(message = "O campo nome é obrigatório.") @Size(min = 3, max = 50) String name,
                     @NotBlank(message = "O campo e-mail é obrigatório.") @Size(min = 11, max = 50) @Email String email,
                     @NotBlank(message = "O campo descrição é obrigatório.") @Size(min = 5, max = 400) String description) {
        this.name = name;
        this.email = email;
        this.description = description;
    }

    public AuthorDto(@NotBlank(message = "O campo nome é obrigatório.")
                     @Size(min = 3, max = 50) String name,
                     @NotBlank(message = "O campo e-mail é obrigatório.")
                     @Size(min = 11, max = 50)
                     @Email(message = "Formato inválido.") String email,
                     @NotBlank(message = "O campo descrição é obrigatório.")
                     @Size(min = 5, max = 400) String description,
                     LocalDateTime createdAt,
                     List<BookDetailDto> books) {

        this.name = name;
        this.email = email;
        this.description = description;
        this.createdAt = createdAt;
        this.books = books;
    }

    public AuthorDto(Author author) {
        this.name = author.getName();
        this.email = author.getEmail();
        this.description = author.getDescription();
        this.createdAt = author.getCreatedAt();
        this.books = new ArrayList<>();
        this.books.addAll(author.getBooks().stream().map(BookDetailDto::new).collect(Collectors.toList()));
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

    public List<BookDetailDto> getBooks() {
        return books;
    }

    public Author toAuthor() {
        return new Author(name, email, description);
    }

    public static List<AuthorDto> toAuthorDto(List<Author> authors) {
        return authors.stream().map(AuthorDto::new).collect(Collectors.toList());
    }
}
