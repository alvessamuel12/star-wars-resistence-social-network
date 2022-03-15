package com.projectgroup.projectv1.utils.validators.gender;


import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.Arrays;
import java.util.List;
import java.util.Locale;

public class GenderValidator implements ConstraintValidator<Gender, String> {

    @Override
    public void initialize(Gender constraintAnnotation) {
        ConstraintValidator.super.initialize(constraintAnnotation);
    }

    @Override
    public boolean isValid(String genderValue, ConstraintValidatorContext context) {
        List<String> allowedGenders = Arrays.asList("male", "female", "nonbinary", "other");

        String cleanValue = genderValue.toLowerCase(Locale.ROOT)
                .replaceAll("-", "")
                .trim();

        return allowedGenders.contains(cleanValue);
    }
}
