package br.com.zup.casadocodigo.utils.builder;

import br.com.zup.casadocodigo.controller.request.BookRequestDto;
import br.com.zup.casadocodigo.model.Book;

import java.math.BigDecimal;
import java.time.LocalDate;

public class BookRequestDtoBuilder {

    private String title;
    private String abstractText;
    private String summary;
    private BigDecimal price;
    private Integer pages;
    private String isbn;
    private LocalDate toBePublishedAt;
    private String categoryName;
    private String authorName;

    public BookRequestDtoBuilder withTitle(String title) {
        this.title = title;
        return this;
    }

    public BookRequestDtoBuilder withAbstract(String abstractText) {
        this.abstractText = abstractText;
        return this;
    }

    public BookRequestDtoBuilder withSummary(String summary) {
        this.summary = summary;
        return this;
    }

    public BookRequestDtoBuilder withPrice(BigDecimal price) {
        this.price = price;
        return this;
    }

    public BookRequestDtoBuilder withPages(Integer pages) {
        this.pages = pages;
        return this;
    }

    public BookRequestDtoBuilder withIsbn(String isbn) {
        this.isbn = isbn;
        return this;
    }

    public BookRequestDtoBuilder withToBePublishedAt(LocalDate toBePublishedAt) {
        this.toBePublishedAt = toBePublishedAt;
        return this;
    }

    public BookRequestDtoBuilder withCategory(String categoryName) {
        this.categoryName = categoryName;
        return this;
    }

    public BookRequestDtoBuilder withAuthor(String authorName) {
        this.authorName = authorName;
        return this;
    }

    public BookRequestDto build() {
        return new BookRequestDto(title, abstractText, summary, price, pages, isbn, toBePublishedAt, categoryName, authorName);
    }
}
