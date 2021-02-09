package br.com.zup.casadocodigo.controller;

import br.com.zup.casadocodigo.controller.request.BookRequestDto;
import br.com.zup.casadocodigo.dto.BookDetailDto;
import br.com.zup.casadocodigo.exception.BookConversionException;
import br.com.zup.casadocodigo.repository.AuthorRepository;
import br.com.zup.casadocodigo.repository.BookRepository;
import br.com.zup.casadocodigo.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.NoSuchElementException;

@RestController
@RequestMapping("/api/v1/books")
public class BookController {

    @Autowired
    private BookRepository repository;

    @Autowired
    private CategoryRepository categoryRepository;

    @Autowired
    private AuthorRepository authorRepository;

    @PostMapping
    public ResponseEntity<BookDetailDto> create(@RequestBody @Valid BookRequestDto bookRequestDto) throws BookConversionException {
        if (!repository.existsBookByTitle(bookRequestDto.convertBookRequestToBook(
                categoryRepository, authorRepository).getTitle())) {

            return ResponseEntity.ok().body(new BookDetailDto(repository.save(bookRequestDto.convertBookRequestToBook(
                    categoryRepository, authorRepository))));
        }
        return ResponseEntity.badRequest().build();
    }

    @GetMapping("{id}")
    public ResponseEntity<BookDetailDto> findById(@PathVariable() Long id) {
        BookDetailDto response = new BookDetailDto(repository.findById(id).orElseThrow(() ->
                new NoSuchElementException("Livro não encontrado.")));
        return ResponseEntity.ok(response);
    }
}
