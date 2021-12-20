package com.salesianostriana.dam.TrianaTourist.validacion.anotaciones;

import com.salesianostriana.dam.TrianaTourist.validacion.validador.UniqueNamePOIValidator;
import com.salesianostriana.dam.TrianaTourist.validacion.validador.UniqueNameRouteValidator;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

@Target({ElementType.METHOD, ElementType.FIELD})
@Constraint(validatedBy = UniqueNamePOIValidator.class)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface UniqueNamePOI {

    String message() default "No puede haber dos elementos iguales";

    Class <?> [] groups() default {};
    Class <? extends Payload> [] payload() default {};
}
