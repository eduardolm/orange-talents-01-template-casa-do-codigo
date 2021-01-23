package br.com.zup.casadocodigo.dto;

import br.com.zup.casadocodigo.model.Author;
import br.com.zup.casadocodigo.model.Book;
import br.com.zup.casadocodigo.model.Category;
import br.com.zup.casadocodigo.validator.UniqueValue;
import org.springframework.beans.factory.annotation.Value;

import javax.persistence.*;
import javax.validation.constraints.*;
import java.math.BigDecimal;
import java.time.LocalDate;

public class BookDto {

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
    private Integer numberOfPages;

    @NotBlank(message = "ISBN é obrigatório.")
    @UniqueValue(domainClass = Book.class, fieldName = "isbn", message = "ISBN deve ser único.")
    private String isbn;

    @Future(message = "Data de publicação deve ser posterior ao dia atual.")
    private LocalDate toBePublishedAt;

    @NotBlank(message = "Categoria é obrigatória.")
    private Category category;

    @NotBlank(message = "Autor é obrigatório.")
    private Author author;

    public BookDto(@NotBlank(message = "Título é obrigatório.") @Size(min = 3, max = 50) String title,
                   @NotBlank(message = "Resumo é obrigatório.") @Size(min = 3, max = 500) String abstractText,
                   @NotBlank(message = "Título é obrigatório.") @Size(min = 3) String summary,
                   @NotNull(message = "O preço é obrigatório.")
                   @DecimalMin(value = "20.0", inclusive = true, message = "Preço mínimo: R$20.00.") BigDecimal price,
                   @NotNull(message = "Número de páginas é obrigatório.") @Min(100) Integer numberOfPages,
                   @NotBlank(message = "ISBN é obrigatório.") String isbn,
                   @Future(message = "Data de publicação deve ser posterior ao dia atual.") LocalDate toBePublishedAt,
                   @NotBlank(message = "Categoria é obrigatória.") Category category,
                   @NotBlank(message = "Autor é obrigatório.") Author author) {

        this.title = title;
        this.abstractText = abstractText;
        this.summary = summary;
        this.price = price;
        this.numberOfPages = numberOfPages;
        this.isbn = isbn;
        this.toBePublishedAt = toBePublishedAt;
        this.category = category;
        this.author = author;
    }

    public BookDto(Book book) {
        this.title = book.getTitle();
        this.abstractText = book.getAbstractText();
        this.summary = book.getSummary();
        this.price = book.getPrice();
        this.numberOfPages = book.getNumberOfPages();
        this.isbn = book.getIsbn();
        this.toBePublishedAt = book.getToBePublishedAt();
        this.category = book.getCategory();
        this.author = book.getAuthor();
    }

    public BookDto() {}

    public String getTitle() {
        return title;
    }

    public String getAbstractText() {
        return abstractText;
    }

    public String getSummary() {
        return summary;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public Integer getNumberOfPages() {
        return numberOfPages;
    }

    public String getIsbn() {
        return isbn;
    }

    public LocalDate getToBePublishedAt() {
        return toBePublishedAt;
    }

    public Category getCategory() {
        return category;
    }

    public Author getAuthor() {
        return author;
    }

    public Book toBook() {
        return new Book(title, abstractText, summary, price, numberOfPages, isbn, toBePublishedAt, category, author);
    }
}
