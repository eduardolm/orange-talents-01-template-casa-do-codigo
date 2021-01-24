package br.com.zup.casadocodigo.controller.request;

import br.com.zup.casadocodigo.exception.BookConversionException;
import br.com.zup.casadocodigo.model.Author;
import br.com.zup.casadocodigo.model.Book;
import br.com.zup.casadocodigo.model.Category;
import br.com.zup.casadocodigo.repository.AuthorRepository;
import br.com.zup.casadocodigo.repository.CategoryRepository;
import br.com.zup.casadocodigo.validator.UniqueValue;

import javax.validation.constraints.*;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.NoSuchElementException;
import java.util.Optional;

public class BookRequest {

    @NotBlank(message = "Título é obrigatório.")
    @UniqueValue(domainClass = Book.class, fieldName = "title", message = "O título deve ser único.")
    @Size(min = 3, max = 50)
    private String title;

    @NotBlank(message = "Resumo é obrigatório.")
    @Size(min = 3, max = 500)
    private String abstractText;

    @NotBlank(message = "Título é obrigatório.")
    @Size(min = 3)
    private String summary;

    @NotNull(message = "O preço é obrigatório.")
    @DecimalMin(value = "20.0", inclusive = true, message = "Preço mínimo: R$20.00.")
    private BigDecimal price;

    @NotNull(message = "Número de páginas é obrigatório.")
    @Min(100)
    private Integer pages;

    @NotBlank(message = "ISBN é obrigatório.")
    @UniqueValue(domainClass = Book.class, fieldName = "isbn", message = "ISBN deve ser único.")
    private String isbn;

    @Future(message = "Data de publicação deve ser posterior ao dia atual.")
    private LocalDate toBePublishedAt;

    @NotBlank(message = "Categoria é obrigatória.")
    private String categoryName;

    @NotBlank(message = "Autor é obrigatório.")
    private String authorName;

    public BookRequest(@NotBlank(message = "Título é obrigatório.") @Size(min = 3, max = 50) String title,
                   @NotBlank(message = "Resumo é obrigatório.") @Size(min = 3, max = 500) String abstractText,
                   @NotBlank(message = "Título é obrigatório.") @Size(min = 3) String summary,
                   @NotNull(message = "O preço é obrigatório.")
                   @DecimalMin(value = "20.0", inclusive = true, message = "Preço mínimo: R$20.00.") BigDecimal price,
                   @NotNull(message = "Número de páginas é obrigatório.")
                   @Min(value = 100, message = "Número de páginas deve ser maior ou igual a 100") Integer pages,
                   @NotBlank(message = "ISBN é obrigatório.") String isbn,
                   @Future(message = "Data de publicação deve ser posterior ao dia atual.") LocalDate toBePublishedAt,
                   @NotBlank(message = "Categoria é obrigatória.") String categoryName,
                   @NotBlank(message = "Autor é obrigatório.") String authorName) {

        this.title = title;
        this.abstractText = abstractText;
        this.summary = summary;
        this.price = price;
        this.pages = pages;
        this.isbn = isbn;
        this.toBePublishedAt = toBePublishedAt;
        this.categoryName = categoryName;
        this.authorName = authorName;
    }

    public Book convertBookRequestToBook(CategoryRepository categoryRepository, AuthorRepository authorRepository) throws NoSuchElementException, BookConversionException {

        Optional<Author> author = authorRepository.findAuthorByName(authorName);
        Optional<Category> category = categoryRepository.findCategoryByName(categoryName);

        if (author.isPresent() && category.isPresent()) {
            return new Book(title, abstractText, summary, price, pages, isbn, toBePublishedAt, category.get(), author.get());
        }
        else {
            throw new BookConversionException(author, category);
        }

    }
}
