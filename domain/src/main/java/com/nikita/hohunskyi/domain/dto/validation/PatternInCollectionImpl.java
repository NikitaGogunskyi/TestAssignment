package com.nikita.hohunskyi.domain.dto.validation;

import com.nikita.hohunskyi.domain.dto.validation.annotation.PatternInCollection;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.Collection;
import java.util.regex.Pattern;

public class PatternInCollectionImpl implements ConstraintValidator<PatternInCollection, Collection<String>> {

    private Pattern pattern;

    @Override
    public void initialize(PatternInCollection constraintAnnotation) {
        pattern = Pattern.compile(constraintAnnotation.regexp());
    }

    @Override
    public boolean isValid(Collection<String> values, ConstraintValidatorContext context) {
        if (values != null) {
            for (String value : values) {
                if (value == null || !pattern
                        .matcher(value)
                        .matches()) {
                    return false;
                }
            }
        }
        return true;
    }
}
