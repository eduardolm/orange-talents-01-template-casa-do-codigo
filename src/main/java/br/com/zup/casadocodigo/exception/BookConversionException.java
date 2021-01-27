package br.com.zup.casadocodigo.exception;

import br.com.zup.casadocodigo.exception.dto.FieldErrorOutputDto;
import br.com.zup.casadocodigo.model.Author;
import br.com.zup.casadocodigo.model.Category;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class BookConversionException extends Throwable {

    private Optional<Author> author;
    private Optional<Category> category;
    private List<FieldErrorOutputDto> errors = new ArrayList<>();

    public BookConversionException(Optional<Author> author, Optional<Category> category) {
        this.author = author;
        this.category = category;
        if (author.isEmpty()) errors.add(new FieldErrorOutputDto("author", "Autor não encontrado."));
        if (category.isEmpty()) errors.add(new FieldErrorOutputDto("category", "Categoria não encontrada."));
    }

    public Optional<Author> getAuthor() {
        return author;
    }

    public Optional<Category> getCategory() {
        return category;
    }

    public List<FieldErrorOutputDto> getErrors() {
        return errors;
    }
}
