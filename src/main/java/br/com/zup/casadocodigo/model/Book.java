package br.com.zup.casadocodigo.model;

import br.com.zup.casadocodigo.dto.CategoryDto;
import br.com.zup.casadocodigo.validator.UniqueValue;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
@Table(name = "livros")
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true)
    private String title;

    @Column(nullable = false)
    private String abstractText;

    @Column(nullable = true)
    private String summary;

    @Column(nullable = false)
    private BigDecimal price;

    @Column(nullable = false)
    private Integer numberOfPages;

    @Column(nullable = false)
    private String isbn;

    @Column(nullable = false)
    private LocalDate toBePublishedAt;

    @Column(nullable = false)
    private Category category;

    @Column(nullable = false)
    private Author author;

    public Book(String title,
                String abstractText,
                String summary,
                BigDecimal price,
                Integer numberOfPages,
                String isbn,
                LocalDate toBePublishedAt,
                Category category,
                Author author) {

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

    public Book() {}

    public Long getId() {
        return id;
    }

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
}
