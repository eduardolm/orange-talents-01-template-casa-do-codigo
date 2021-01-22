package br.com.zup.casadocodigo.validator;

import br.com.zup.casadocodigo.dto.AuthorDto;
import br.com.zup.casadocodigo.model.Author;
import br.com.zup.casadocodigo.repository.AuthorRepository;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.mockito.Mockito;
import org.springframework.validation.BeanPropertyBindingResult;
import org.springframework.validation.Errors;

import java.util.Optional;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class UniqueEmailValidatorTest {

    @DisplayName("Duplicate e-mail should be forbidden")
    @ParameterizedTest
    @MethodSource("generateTest")
    public void duplicateEmailShouldBeForbidden(Optional<Author> tempAuthor, boolean expected) {
        AuthorRepository authorRepository = Mockito.mock(AuthorRepository.class);
        UniqueEmailValidator validator = new UniqueEmailValidator(authorRepository);
        Object target = new AuthorDto(new Author("John Doe", "john@email.com", "Autor para teste."));
        Errors errors = new BeanPropertyBindingResult(target, "duplicateEmailShouldBeForbidden");
        Mockito.when(authorRepository.findByEmail("john@email.com")).thenReturn(tempAuthor);

        validator.validate(target, errors);
        assertEquals(expected, errors.hasFieldErrors("email"));
    }

    private static Stream<Arguments> generateTest() {
        Optional<Author> author = Optional.of(new Author("John Doe", "john@email.com", "Autor para teste."));
        return Stream.of(Arguments.of(author, true), Arguments.of(Optional.empty(), false));
    }
}
