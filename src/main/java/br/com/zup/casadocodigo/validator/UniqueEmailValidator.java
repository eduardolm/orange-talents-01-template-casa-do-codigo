package br.com.zup.casadocodigo.validator;

import br.com.zup.casadocodigo.dto.AuthorDto;
import br.com.zup.casadocodigo.model.Author;
import br.com.zup.casadocodigo.repository.AuthorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import java.util.Optional;

@Component
public class UniqueEmailValidator implements Validator {

    @Autowired
    private AuthorRepository authorRepository;

    @Override
    public boolean supports(Class<?> aClass) {
        return AuthorDto.class.isAssignableFrom(aClass);
    }

    @Override
    public void validate(Object obj, Errors errors) {
        if (errors.hasErrors()) {
            return;
        }
        AuthorDto request = (AuthorDto) obj;
        Optional<Author> tempAuthor = authorRepository.findByEmail(request.getEmail());
        if (tempAuthor.isPresent()) {
            errors.rejectValue("email", null, "E-mail já cadastrado em nosso sistema.");
        }
    }
}
