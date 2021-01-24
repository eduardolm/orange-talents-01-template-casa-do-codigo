package br.com.zup.casadocodigo.controller;

import br.com.zup.casadocodigo.dto.AuthorDto;
import br.com.zup.casadocodigo.model.Author;
import br.com.zup.casadocodigo.repository.AuthorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;

import javax.transaction.Transactional;
import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/v1/authors")
public class AuthorController {

    @Autowired
    private AuthorRepository repository;

    @PostMapping
    @Transactional
    public ResponseEntity<AuthorDto> create(@RequestBody @Valid AuthorDto authorDto) {
        if (!repository.existsAuthorByEmail(authorDto.toAuthor().getEmail())) {
            return ResponseEntity.ok().body(new AuthorDto(repository.save(authorDto.toAuthor())));
        }
        return ResponseEntity.badRequest().build();
    }

    @GetMapping
    public ResponseEntity<List<AuthorDto>> findAll() {
        List<Author> authors = repository.findAll();
        return ResponseEntity.ok(AuthorDto.toAuthorDto(authors));
    }
}
