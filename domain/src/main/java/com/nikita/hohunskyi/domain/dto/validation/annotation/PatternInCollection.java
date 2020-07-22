package com.nikita.hohunskyi.domain.dto.validation.annotation;

import com.nikita.hohunskyi.domain.dto.validation.PatternInCollectionImpl;

import javax.validation.Constraint;
import javax.validation.Payload;
import javax.validation.ReportAsSingleViolation;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.FIELD;
import static java.lang.annotation.ElementType.PARAMETER;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

@Constraint(validatedBy = PatternInCollectionImpl.class)
@Target({FIELD, PARAMETER})
@Retention(RUNTIME)
@ReportAsSingleViolation
public @interface PatternInCollection {

    String DEFAULT_MESSAGE = "PatternInCollection.message";

    /**
     * @return string
     */
    String regexp();

    /**
     * @return string
     */
    String message() default DEFAULT_MESSAGE;

    /**
     * @return Class<?>[]
     */
    Class<?>[] groups() default {};

    /**
     * @return Class<?               extends               Payload>[]
     */
    Class<? extends Payload>[] payload() default {};
}

