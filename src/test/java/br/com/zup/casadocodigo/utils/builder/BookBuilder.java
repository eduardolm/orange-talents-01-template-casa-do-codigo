package br.com.zup.casadocodigo.utils.builder;

import br.com.zup.casadocodigo.controller.request.BookRequestDto;
import br.com.zup.casadocodigo.model.Author;
import br.com.zup.casadocodigo.model.Book;
import br.com.zup.casadocodigo.model.Category;

import java.math.BigDecimal;
import java.time.LocalDate;

public class BookBuilder {

    private String title;
    private String abstractText;
    private String summary;
    private BigDecimal price;
    private Integer pages;
    private String isbn;
    private LocalDate toBePublishedAt;
    private Category category;
    private Author author;

    public BookBuilder withTitle(String title) {
        this.title = title;
        return this;
    }

    public BookBuilder withAbstract(String abstractText) {
        this.abstractText = abstractText;
        return this;
    }

    public BookBuilder withSummary(String summary) {
        this.summary = summary;
        return this;
    }

    public BookBuilder withPrice(BigDecimal price) {
        this.price = price;
        return this;
    }

    public BookBuilder withPages(Integer pages) {
        this.pages = pages;
        return this;
    }

    public BookBuilder withIsbn(String isbn) {
        this.isbn = isbn;
        return this;
    }

    public BookBuilder withToBePublishedAt(LocalDate toBePublishedAt) {
        this.toBePublishedAt = toBePublishedAt;
        return this;
    }

    public BookBuilder withCategory(Category category) {
        this.category = category;
        return this;
    }

    public BookBuilder withAuthor(Author author) {
        this.author = author;
        return this;
    }

    public Book build() {
        return new Book(title, abstractText, summary, price, pages, isbn, toBePublishedAt, category, author);
    }
}
