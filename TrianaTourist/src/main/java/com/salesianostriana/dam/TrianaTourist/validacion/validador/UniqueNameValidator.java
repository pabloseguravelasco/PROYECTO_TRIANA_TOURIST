package com.salesianostriana.dam.TrianaTourist.validacion.validador;

import com.salesianostriana.dam.TrianaTourist.repository.POIRepository;
import com.salesianostriana.dam.TrianaTourist.validacion.anotaciones.UniqueName;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class UniqueNameValidator implements ConstraintValidator<UniqueName, String> {

    @Autowired
    private POIRepository poiRepository;

    @Override
    public void initialize(UniqueName constraintAnnotation) {
    }

    @Override
    public boolean isValid(String name, ConstraintValidatorContext constraintValidatorContext) {
        return StringUtils.hasText(name) && !poiRepository.existsByName(name);
    }
}
