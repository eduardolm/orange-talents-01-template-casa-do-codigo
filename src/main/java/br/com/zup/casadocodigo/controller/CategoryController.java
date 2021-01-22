package br.com.zup.casadocodigo.controller;

import br.com.zup.casadocodigo.dto.CategoryDto;
import br.com.zup.casadocodigo.repository.CategoryRepository;
import br.com.zup.casadocodigo.validator.UniqueCategoryValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;

import javax.transaction.Transactional;
import javax.validation.Valid;

@RestController
@RequestMapping("/api/v1/categories")
public class CategoryController {

    @Autowired
    private CategoryRepository repository;

    @Autowired
    private UniqueCategoryValidator uniqueCategoryValidator;

    @InitBinder
    public void init(WebDataBinder binder) {
        binder.addValidators(uniqueCategoryValidator);
    }

    @PostMapping
    @Transactional
    public ResponseEntity<CategoryDto> create(@RequestBody @Valid CategoryDto categoryDto) {
        return ResponseEntity.ok().body(new CategoryDto(repository.save(categoryDto.toCategory())));
    }
}
