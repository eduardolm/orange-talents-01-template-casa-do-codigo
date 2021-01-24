package br.com.zup.casadocodigo.dto;

import br.com.zup.casadocodigo.model.Book;
import br.com.zup.casadocodigo.repository.AuthorRepository;
import br.com.zup.casadocodigo.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.math.BigDecimal;
import java.time.LocalDate;

public class BookDetailDto {

    @Autowired
    private CategoryRepository categoryRepository;

    @Autowired
    private AuthorRepository authorRepository;

    private Long id;
    private String title;
    private String abstractText;
    private String summary;
    private BigDecimal price;
    private Integer pages;
    private String isbn;
    private LocalDate toBePublishedAt;
    private String category;
    private String author;

    public BookDetailDto(Long id,
                         String title,
                         String abstractText,
                         String summary,
                         BigDecimal price,
                         Integer pages,
                         String isbn,
                         LocalDate toBePublishedAt,
                         String category,
                         String author) {

        this.id = id;
        this.title = title;
        this.abstractText = abstractText;
        this.summary = summary;
        this.price = price;
        this.pages = pages;
        this.isbn = isbn;
        this.toBePublishedAt = toBePublishedAt;
        this.category = category;
        this.author = author;
    }

    public BookDetailDto(Book book) {
        this.id = book.getId();
        this.title = book.getTitle();
        this.abstractText = book.getAbstractText();
        this.summary = book.getSummary();
        this.price = book.getPrice();
        this.pages = book.getPages();
        this.isbn = book.getIsbn();
        this.toBePublishedAt = book.getToBePublishedAt();
        this.category = book.getCategory().getName();
        this.author = book.getAuthor().getName();
    }

    public BookDetailDto() {}

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

    public Integer getPages() {
        return pages;
    }

    public String getIsbn() {
        return isbn;
    }

    public LocalDate getToBePublishedAt() {
        return toBePublishedAt;
    }

    public String getCategory() {
        return category;
    }

    public String getAuthor() {
        return author;
    }
}
