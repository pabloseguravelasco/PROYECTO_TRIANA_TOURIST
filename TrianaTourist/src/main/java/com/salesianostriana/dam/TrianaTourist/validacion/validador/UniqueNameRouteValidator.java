package com.salesianostriana.dam.TrianaTourist.validacion.validador;

import com.salesianostriana.dam.TrianaTourist.repository.CategoryRepository;
import com.salesianostriana.dam.TrianaTourist.repository.RouteRepository;
import com.salesianostriana.dam.TrianaTourist.validacion.anotaciones.UniqueName;
import com.salesianostriana.dam.TrianaTourist.validacion.anotaciones.UniqueNameRoute;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class UniqueNameRouteValidator implements ConstraintValidator<UniqueNameRoute, String> {

    @Autowired
    private RouteRepository routeRepository;

    @Override
    public void initialize(UniqueNameRoute constraintAnnotation) {
    }

    @Override
    public boolean isValid(String name, ConstraintValidatorContext constraintValidatorContext) {
        return StringUtils.hasText(name) && !routeRepository.existsByName(name);
    }
}
