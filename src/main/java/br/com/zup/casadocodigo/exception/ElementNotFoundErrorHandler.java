package br.com.zup.casadocodigo.exception;

import br.com.zup.casadocodigo.exception.dto.FieldErrorOutputDto;
import br.com.zup.casadocodigo.exception.dto.NoSuchElementExceptionOutputDto;
import br.com.zup.casadocodigo.exception.dto.ValidationErrorsOutputDto;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

@RestControllerAdvice
public class ElementNotFoundErrorHandler {

    @ResponseStatus(HttpStatus.NOT_FOUND)
    @ExceptionHandler(NoSuchElementException.class)
    public NoSuchElementExceptionOutputDto handleNoSuchElementErrors(NoSuchElementException exception) {
        List<String> globalErrors = new ArrayList<>();
        globalErrors.add(exception.getMessage());

        return buildNoSuchElementError(globalErrors);
    }

    private NoSuchElementExceptionOutputDto buildNoSuchElementError(List<String> globalErrors) {
        NoSuchElementExceptionOutputDto notFoundErrors = new NoSuchElementExceptionOutputDto();

        globalErrors.forEach(notFoundErrors::addError);
        return notFoundErrors;
    }

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(BookConversionException.class)
    public ValidationErrorsOutputDto handleBookConvertionException(BookConversionException exception) {

        List<FieldErrorOutputDto> fieldErrors = exception.getErrors();

        return buildBookConvertionException(fieldErrors);
    }

    private ValidationErrorsOutputDto buildBookConvertionException( List<FieldErrorOutputDto> fieldErrors) {
        ValidationErrorsOutputDto bookConversionErrors = new ValidationErrorsOutputDto();

        fieldErrors.forEach(error -> {
            String errorMessage = error.getMessage();
            bookConversionErrors.addFieldError(error.getField(), errorMessage);
        });
        return bookConversionErrors;
    }

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(StateConversionException.class)
    public ValidationErrorsOutputDto handleStateConversionException(StateConversionException exception) {

        List<FieldErrorOutputDto> fieldErrors = exception.getErrors();

        return buildStateConversionException(fieldErrors);
    }

    private ValidationErrorsOutputDto buildStateConversionException( List<FieldErrorOutputDto> fieldErrors) {
        ValidationErrorsOutputDto stateConversionErrors = new ValidationErrorsOutputDto();

        fieldErrors.forEach(error -> {
            String errorMessage = error.getMessage();
            stateConversionErrors.addFieldError(error.getField(), errorMessage);
        });
        return stateConversionErrors;
    }
}
