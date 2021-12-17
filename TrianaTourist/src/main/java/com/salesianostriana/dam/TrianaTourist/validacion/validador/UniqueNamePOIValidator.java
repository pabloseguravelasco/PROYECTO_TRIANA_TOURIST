package com.salesianostriana.dam.TrianaTourist.validacion.validador;

import com.salesianostriana.dam.TrianaTourist.repository.POIRepository;
import com.salesianostriana.dam.TrianaTourist.validacion.anotaciones.UniqueNamePOI;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class UniqueNamePOIValidator  implements ConstraintValidator<UniqueNamePOI, String> {

    @Autowired
    private POIRepository poiRepository;

    @Override
    public void initialize(UniqueNamePOI constraintAnnotation) {
    }

    @Override
    public boolean isValid(String name, ConstraintValidatorContext constraintValidatorContext) {
        return StringUtils.hasText(name) && !poiRepository.existsByName(name);
    }
}
