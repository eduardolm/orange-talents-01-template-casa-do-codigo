package br.com.zup.casadocodigo.dto;

import br.com.zup.casadocodigo.model.Category;
import br.com.zup.casadocodigo.validator.UniqueValue;

import javax.validation.constraints.NotBlank;

public class CategoryDto {

    @UniqueValue(domainClass = Category.class, fieldName = "name", message = "Categoria já cadastrada.")
    @NotBlank(message = "O nome da categoria é obrigatório.")
    private String name;

    public CategoryDto(@NotBlank(message = "O nome da categoria é obrigatório.") String name) {
        this.name = name;
    }

    public CategoryDto(Category category) {
        this.name = category.getName();
    }

    public CategoryDto() {}

    public String getName() {
        return name;
    }

    public Category toCategory() {
        return new Category(name);
    }
}
