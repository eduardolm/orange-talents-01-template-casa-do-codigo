package br.com.zup.casadocodigo.exception;

import br.com.zup.casadocodigo.dto.SQLExceptionDto;
import br.com.zup.casadocodigo.exception.dto.AuthorDtoException;
import org.springframework.context.MessageSource;
import org.springframework.context.MessageSourceResolvable;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.http.HttpStatus;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.sql.SQLIntegrityConstraintViolationException;
import java.util.ArrayList;
import java.util.List;

@RestControllerAdvice
public class ExceptionHandler {

    private MessageSource messageSource;

    public ExceptionHandler(MessageSource messageSource) {
        this.messageSource = messageSource;
    }

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @org.springframework.web.bind.annotation.ExceptionHandler(MethodArgumentNotValidException.class)
    public List<AuthorDtoException> handleMethodArgumentNotValidException(MethodArgumentNotValidException exception) {
        List<AuthorDtoException> dto = new ArrayList<>();
        List<FieldError> fieldErrors = exception.getBindingResult().getFieldErrors();

        fieldErrors.forEach(e -> {
            String message = messageSource.getMessage(e, LocaleContextHolder.getLocale());
            AuthorDtoException error = new AuthorDtoException(e.getField(), message);
            dto.add(error);
        });
        return dto;
    }

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @org.springframework.web.bind.annotation.ExceptionHandler(SQLIntegrityConstraintViolationException.class)
    public List<SQLExceptionDto> handleSQLIntegrityConstraintViolationException(SQLIntegrityConstraintViolationException exception) {
        List<SQLExceptionDto> dto = new ArrayList<>();
        String message = messageSource.getMessage((MessageSourceResolvable) exception, LocaleContextHolder.getLocale());
        SQLExceptionDto error = new SQLExceptionDto(exception.getCause().toString(), message);
        dto.add(error);
        return dto;
    }

}
