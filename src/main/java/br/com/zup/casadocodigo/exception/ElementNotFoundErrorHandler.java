package br.com.zup.casadocodigo.exception;

import br.com.zup.casadocodigo.exception.dto.BookConversionExceptionOutputDto;
import br.com.zup.casadocodigo.exception.dto.FieldErrorOutputDto;
import br.com.zup.casadocodigo.exception.dto.NoSuchElementExceptionOutputDto;
import org.springframework.http.HttpStatus;
import org.springframework.validation.FieldError;
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
    public BookConversionExceptionOutputDto handleBookConvertionException(BookConversionException exception) {

        List<FieldErrorOutputDto> fieldErrors = exception.getErrors();

        return buildBookConvertionException(fieldErrors);
    }

    private BookConversionExceptionOutputDto buildBookConvertionException( List<FieldErrorOutputDto> fieldErrors) {
        BookConversionExceptionOutputDto bookConversionErrors = new BookConversionExceptionOutputDto();

        fieldErrors.forEach(error -> {
            String errorMessage = error.getMessage();
            bookConversionErrors.addFieldError(error.getField(), errorMessage);
        });
        return bookConversionErrors;
    }
}
