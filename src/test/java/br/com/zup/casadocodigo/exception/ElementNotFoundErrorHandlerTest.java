package br.com.zup.casadocodigo.exception;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

import java.util.List;
import java.util.NoSuchElementException;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ContextConfiguration(classes = {ElementNotFoundErrorHandler.class})
@ExtendWith(SpringExtension.class)
public class ElementNotFoundErrorHandlerTest {
    @Autowired
    private ElementNotFoundErrorHandler elementNotFoundErrorHandler;

    @Test
    public void testHandleNoSuchElementErrors() {
        // Arrange, Act and Assert
        List<String> errors = this.elementNotFoundErrorHandler.handleNoSuchElementErrors(new NoSuchElementException())
                .getErrors();
        assertEquals(1, errors.size());
        assertNull(errors.get(0));
    }

    @Test
    public void testHandleNoSuchElementErrors2() {
        // Arrange
        NoSuchElementException noSuchElementException = new NoSuchElementException();
        noSuchElementException
                .setStackTrace(new StackTraceElement[]{new StackTraceElement("Declaring Class",
                        "Method Name", "foo.txt", 2)});

        // Act and Assert
        List<String> errors = this.elementNotFoundErrorHandler.handleNoSuchElementErrors(noSuchElementException)
                .getErrors();
        assertEquals(1, errors.size());
        assertNull(errors.get(0));
    }
}

