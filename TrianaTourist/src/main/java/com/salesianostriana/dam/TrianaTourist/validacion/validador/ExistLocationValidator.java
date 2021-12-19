package com.salesianostriana.dam.TrianaTourist.validacion.validador;

import com.salesianostriana.dam.TrianaTourist.validacion.anotaciones.ExistLocation;
import org.springframework.beans.PropertyAccessorFactory;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.regex.Pattern;

public class ExistLocationValidator implements ConstraintValidator<ExistLocation, Object> {

    String location;

    @Override
    public void initialize(ExistLocation constraintAnnotation) {

        this.location = constraintAnnotation.location();
    }

    @Override
    public boolean isValid(Object o, ConstraintValidatorContext constraintValidatorContext) {
        Object fieldValue = PropertyAccessorFactory.forBeanPropertyAccess(o).getPropertyValue(location);

        if (fieldValue != null){
            return Pattern.matches("^([-+]?\\d{1,2}[.]\\d+),\\s*([-+]?\\d{1,3}[.]\\d+)$", (CharSequence) fieldValue);
        }
            return fieldValue == null;

        }
    }

