package br.com.zup.casadocodigo.controller;

import br.com.zup.casadocodigo.dto.BookDto;
import br.com.zup.casadocodigo.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping("/api/v1/books")
public class BookController {

    @Autowired
    private BookRepository repository;

    @PostMapping
    public ResponseEntity<BookDto> create(@RequestBody @Valid BookDto bookDto) {
        if (!repository.existsBookByTitle(bookDto.toBook().getTitle())) {
            return ResponseEntity.ok().body(new BookDto(repository.save(bookDto.toBook())));
        }
        return ResponseEntity.badRequest().build();
    }
}
