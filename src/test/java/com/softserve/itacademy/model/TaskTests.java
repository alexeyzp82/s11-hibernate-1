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

@SpringBootTest(classes = TaskTests.class)
public class TaskTests {

    @ParameterizedTest
    @MethodSource("provideName")
    void constraintViolationTitle(String name, boolean isValid) {
        Task task = new Task();
        task.setName(name);
        task.setState(new State());
        task.setPriority(Priority.MEDIUM);
        task.setTodo(new ToDo());


        try (ValidatorFactory factory = Validation.buildDefaultValidatorFactory()) {
            Validator validator = factory.getValidator();
            Set<ConstraintViolation<Task>> violations = validator.validate(task);
            assertEquals(isValid ? 0 : 1, violations.size());
        }
    }

    public static Stream<Arguments> provideName() {
        char[] manyChars = new char[256];
        Arrays.fill(manyChars, 'a');

        return Stream.of(
                Arguments.of("Valid name", true),
                Arguments.of("xy", false),
                Arguments.of("xyz", true),
                Arguments.of(null, false),
                Arguments.of(new String(manyChars), false)
        );
    }
}
