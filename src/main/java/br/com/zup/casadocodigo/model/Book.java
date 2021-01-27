package br.com.zup.casadocodigo.model;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Objects;
import java.util.StringJoiner;

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
    private Integer pages;

    @Column(nullable = false)
    private String isbn;

    @Column(nullable = false)
    private LocalDate toBePublishedAt;

    @ManyToOne
    private Author author;

    @ManyToOne
    private Category category;

    public Book(String title,
                String abstractText,
                String summary,
                BigDecimal price,
                Integer pages,
                String isbn,
                LocalDate toBePublishedAt,
                Category category,
                Author author) {

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

    public Integer getPages() {
        return pages;
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

    @Override
    public String toString() {
        return new StringJoiner(", ", Book.class.getSimpleName() + "[", "]")
                .add("Id: '" + id + "'")
                .add("Título: '" + title + "'")
                .add("Resumo: '" + abstractText + "'")
                .add("Sumário: '" + summary + "'")
                .add("Preço: '" + price + "'")
                .add("Páginas: '" + pages + "'")
                .add("ISBN: '" + isbn + "'")
                .add("Publicação: '" + toBePublishedAt + "'")
                .add("Categoria: '" + category.getName() + "'")
                .add("Autor: '" + author.getName() + "'")
                .toString();
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((id == null) ? 0 : id.hashCode());
        result = prime * result + ((title == null) ? 0 : title.hashCode());
        result = prime * result + ((abstractText == null) ? 0 : abstractText.hashCode());
        result = prime * result + ((summary == null) ? 0 : summary.hashCode());
        result = prime * result + ((price == null) ? 0 : price.hashCode());
        result = prime * result + ((pages == null) ? 0 : pages.hashCode());
        result = prime * result + ((isbn == null) ? 0 : isbn.hashCode());
        result = prime * result + ((toBePublishedAt == null) ? 0 : toBePublishedAt.hashCode());
        result = prime * result + ((category.getName() == null) ? 0 : category.getName().hashCode());
        result = prime * result + ((author.getName() == null) ? 0 : author.getName().hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof Book)) {
            return false;
        }
        Book other = (Book) obj;
        return (Objects.equals(id, other.getId()))
                && (Objects.equals(title, other.getTitle()))
                && (Objects.equals(abstractText, other.getAbstractText()))
                && (Objects.equals(summary, other.getSummary()))
                && (Objects.equals(price, other.getPrice()))
                && (Objects.equals(isbn, other.getIsbn()))
                && (Objects.equals(toBePublishedAt, other.getToBePublishedAt()))
                && (Objects.equals(category.getName(), other.getCategory().getName()))
                && (Objects.equals(author.getName(), other.getAuthor().getName()));
    }
}
