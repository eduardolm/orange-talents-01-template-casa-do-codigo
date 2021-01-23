package br.com.zup.casadocodigo.validator;

import br.com.zup.casadocodigo.dto.CategoryDto;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.web.servlet.MockMvc;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest
@AutoConfigureMockMvc
@ActiveProfiles("test")
public class ValidatorTest {

    @Autowired
    private final Validator validator = Validation.buildDefaultValidatorFactory().getValidator();

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void shouldReturnViolationWhenNameIsBank() {

        CategoryDto categoryDto = new CategoryDto();
        Set<ConstraintViolation<CategoryDto>> violations = validator.validate(categoryDto);

        assertEquals(1, violations.size());
        assertNotNull(violations);
    }

    @Test
    public void shouldHaveNoViolationWhenNameUnique() {

        CategoryDto categoryDto = new CategoryDto();
        categoryDto.setName("Children");
        Set<ConstraintViolation<CategoryDto>> violations = validator.validate(categoryDto);

        assertEquals(0, violations.size());
    }
}
