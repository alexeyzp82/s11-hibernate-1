package com.softserve.itacademy.model;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.springframework.boot.test.context.SpringBootTest;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;
import java.util.Arrays;
import java.util.Set;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest(classes = ToDoTests.class)
public class ToDoTests {

    @ParameterizedTest
    @MethodSource("provideTitle")
    void constraintViolationTitle(String title, boolean isValid) {
        ToDo toDo = new ToDo();
        toDo.setTitle(title);

        try (ValidatorFactory factory = Validation.buildDefaultValidatorFactory()) {
            Validator validator = factory.getValidator();
            Set<ConstraintViolation<ToDo>> violations = validator.validate(toDo);
            assertEquals(isValid ? 0 : 1, violations.size());
        }
    }

    public static Stream<Arguments> provideTitle() {
        char[] manyChars = new char[256];
        Arrays.fill(manyChars, 'a');

        return Stream.of(
                Arguments.of("Valid title", true),
                Arguments.of("", false),
                Arguments.of("   ", false),
                Arguments.of(null, false),
                Arguments.of(new String(manyChars), false)
        );
    }
}
