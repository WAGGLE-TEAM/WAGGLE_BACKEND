package com.trip.common.annotation;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

/**
 * code reference from: https://tommykim.tistory.com/20
 */
public class TypeValidator implements ConstraintValidator<ValidateType, String> {

    private ValidateType validateType;

    /**
     * constraintAnnotation에 있는 정보를 멤버 변수로 저장하여 IsValid()에서 사용해야 할 때 사용
     */
    @Override
    public void initialize(ValidateType constraintAnnotation) {
        this.validateType = constraintAnnotation;
    }

    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        Enum<?>[] enumValues = this.validateType.enumClass().getEnumConstants();
        if (enumValues != null) {
            for (Object enumValue : enumValues) {
                if (
                    value.equals(enumValue.toString())
                    || this.validateType.ignoreCase() && value.equalsIgnoreCase(enumValue.toString())
                ) {
                    return true;
                }
            }
        }

        return false;
    }
}
