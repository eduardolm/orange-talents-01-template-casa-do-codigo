package br.com.zup.casadocodigo.validator;

import br.com.zup.casadocodigo.dto.CategoryDto;
import br.com.zup.casadocodigo.model.Category;
import br.com.zup.casadocodigo.repository.CategoryRepository;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import java.util.Optional;

@Component
public class UniqueCategoryValidator implements Validator {

    private CategoryRepository categoryRepository;

    public UniqueCategoryValidator(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    @Override
    public boolean supports(Class<?> aClass) {
        return CategoryDto.class.isAssignableFrom(aClass);
    }

    @Override
    public void validate(Object obj, Errors errors) {
        if (errors.hasErrors()) {
            return;
        }
        CategoryDto request = (CategoryDto) obj;
        Optional<Category> tempCategory = categoryRepository.findByName(request.getName());
        if (tempCategory.isPresent()) {
            errors.rejectValue("name", null, "Categoria já cadastrada em nosso sistema.");
        }
    }
}
