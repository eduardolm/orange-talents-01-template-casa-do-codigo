package br.com.zup.casadocodigo.validator.constraints;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.hibernate.validator.internal.engine.constraintvalidation.ConstraintValidatorContextImpl;
import org.hibernate.validator.internal.engine.path.PathImpl;
import org.junit.jupiter.api.Test;

public class CPFeCNPJValidatorTest {
    @Test
    public void testIsValid() {
        // Arrange
        ConstraintValidatorContextImpl context = new ConstraintValidatorContextImpl(null, PathImpl.createRootPath(), null,
                "constraintValidatorPayload");

        // Act and Assert
        assertFalse((new CPFeCNPJValidator()).isValid("value", context));
    }

    @Test
    public void testIsValid2() {
        // Arrange
        ConstraintValidatorContextImpl context = new ConstraintValidatorContextImpl(null, PathImpl.createRootPath(), null,
                "constraintValidatorPayload");

        // Act and Assert
        assertTrue((new CPFeCNPJValidator()).isValid(null, context));
    }

    @Test
    public void testIsValid3() {
        // Arrange
        ConstraintValidatorContextImpl context = new ConstraintValidatorContextImpl(null, PathImpl.createRootPath(), null,
                "constraintValidatorPayload");

        // Act and Assert
        assertTrue((new CPFeCNPJValidator()).isValid("", context));
    }

    @Test
    public void testIsValid4() {
        // Arrange
        ConstraintValidatorContextImpl context = new ConstraintValidatorContextImpl(null, PathImpl.createRootPath(), null,
                "constraintValidatorPayload");

        // Act and Assert
        assertTrue((new CPFeCNPJValidator()).isValid("00000000000000", context));
    }

    @Test
    public void testIsValid5() {
        // Arrange
        ConstraintValidatorContextImpl context = new ConstraintValidatorContextImpl(null, PathImpl.createRootPath(), null,
                "constraintValidatorPayload");

        // Act and Assert
        assertFalse((new CPFeCNPJValidator()).isValid("11111111111111", context));
    }

    @Test
    public void testIsValid6() {
        // Arrange
        ConstraintValidatorContextImpl context = new ConstraintValidatorContextImpl(null, PathImpl.createRootPath(), null,
                "constraintValidatorPayload");

        // Act and Assert
        assertFalse((new CPFeCNPJValidator()).isValid("22222222222222", context));
    }

    @Test
    public void testIsValid7() {
        // Arrange
        ConstraintValidatorContextImpl context = new ConstraintValidatorContextImpl(null, PathImpl.createRootPath(), null,
                "constraintValidatorPayload");

        // Act and Assert
        assertFalse((new CPFeCNPJValidator()).isValid("33333333333333", context));
    }
}

