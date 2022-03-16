package com.projectgroup.projectv1.utils.validators.uuid;


import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;


public class UUIDValidator implements ConstraintValidator<UUID, java.util.UUID> {

    @Override
    public void initialize(UUID constraintAnnotation) {
        ConstraintValidator.super.initialize(constraintAnnotation);
    }

    @Override
    public boolean isValid(java.util.UUID uuidValue, ConstraintValidatorContext context) {

        return uuidValue
                .toString()
                .matches("^[0-9a-f]{8}-[0-9a-f]{4}-[1-5][0-9a-f]{3}-[89ab][0-9a-f]{3}-[0-9a-f]{12}$");
    }
}
