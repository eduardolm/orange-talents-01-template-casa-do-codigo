package br.com.zup.casadocodigo.exception;

import br.com.zup.casadocodigo.exception.dto.ValidationErrorsOutputDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.http.HttpStatus;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.List;

@RestControllerAdvice
public class ValidationErrorHandler {

    @Autowired
    private MessageSource messageSource;

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ValidationErrorsOutputDto handleValidtionErrors(MethodArgumentNotValidException exception) {

        List<ObjectError> globalErrors = exception.getBindingResult().getGlobalErrors();
        List<FieldError> fieldErrors = exception.getBindingResult().getFieldErrors();

        return buildValidationErrors(globalErrors, fieldErrors);
    }

    private ValidationErrorsOutputDto buildValidationErrors(List<ObjectError> globalErrors, List<FieldError> fieldErrors) {
        ValidationErrorsOutputDto validationErrors = new ValidationErrorsOutputDto();

        globalErrors.forEach(error -> validationErrors.addError(getErrorMessage(error)));

        fieldErrors.forEach(error -> {
            String errorMessage = getErrorMessage(error);
            validationErrors.addFieldError(error.getField(), errorMessage);
        });
        return validationErrors;
    }

    private String getErrorMessage(ObjectError error) {
        return messageSource.getMessage(error, LocaleContextHolder.getLocale());
    }


//    @ResponseStatus(HttpStatus.BAD_REQUEST)
//    @org.springframework.web.bind.annotation.ExceptionHandler(MethodArgumentNotValidException.class)
//    public List<AuthorDtoException> handleMethodArgumentNotValidException(MethodArgumentNotValidException exception) {
//        List<AuthorDtoException> dto = new ArrayList<>();
//        List<FieldError> fieldErrors = exception.getBindingResult().getFieldErrors();
//
//        fieldErrors.forEach(e -> {
//            String message = messageSource.getMessage(e, LocaleContextHolder.getLocale());
//            AuthorDtoException error = new AuthorDtoException(e.getField(), message);
//            dto.add(error);
//        });
//        return dto;
//    }
//
//    @ResponseStatus(HttpStatus.BAD_REQUEST)
//    @org.springframework.web.bind.annotation.ExceptionHandler(SQLIntegrityConstraintViolationException.class)
//    public List<SQLExceptionDto> handleSQLIntegrityConstraintViolationException(SQLIntegrityConstraintViolationException exception) {
//        List<SQLExceptionDto> dto = new ArrayList<>();
//        String message = messageSource.getMessage((MessageSourceResolvable) exception, LocaleContextHolder.getLocale());
//        SQLExceptionDto error = new SQLExceptionDto(exception.getCause().toString(), message);
//        dto.add(error);
//        return dto;
//    }

}
