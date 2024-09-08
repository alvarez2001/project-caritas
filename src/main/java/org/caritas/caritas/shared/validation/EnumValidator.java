package org.caritas.caritas.shared.validation;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class EnumValidator implements ConstraintValidator<ValidEnum, Object> {

    private Class<? extends Enum<?>> enumClass;

    @Override
    public void initialize(ValidEnum constraintAnnotation) {
        this.enumClass = constraintAnnotation.enumClass();
    }

    @Override
    public boolean isValid(Object value, ConstraintValidatorContext context) {
        if (value == null) {
            return true; // Permite valores nulos; para evitar esto, usa @NotNull junto con @ValidEnum
        }

        if (value instanceof String) {
            for (Enum<?> enumValue : enumClass.getEnumConstants()) {
                if (enumValue.name().equals(value)) {
                    return true;
                }
            }
        } else if (enumClass.isInstance(value)) {
            return true; // El valor ya es una instancia del enum
        }

        return false;
    }
}