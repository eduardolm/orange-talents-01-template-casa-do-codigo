package br.com.zup.casadocodigo.controller;

import br.com.zup.casadocodigo.dto.AuthorDto;
import br.com.zup.casadocodigo.repository.AuthorRepository;
import br.com.zup.casadocodigo.validator.UniqueEmailValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;

import javax.transaction.Transactional;
import javax.validation.Valid;

@RestController
@RequestMapping("/api/v1/authors")
public class AuthorController {

    @Autowired
    private AuthorRepository repository;

    @Autowired
    private UniqueEmailValidator uniqueEmailValidator;

    @InitBinder
    public void init(WebDataBinder binder) {
        binder.addValidators(uniqueEmailValidator);
    }

    @PostMapping
    @Transactional
    public ResponseEntity<AuthorDto> create(@RequestBody @Valid AuthorDto authorDto) {
        if (!repository.existsAuthorByEmail(authorDto.toAuthor().getEmail())) {
            return ResponseEntity.ok().body(new AuthorDto(repository.save(authorDto.toAuthor())));
        }
        return ResponseEntity.badRequest().build();
    }
}
