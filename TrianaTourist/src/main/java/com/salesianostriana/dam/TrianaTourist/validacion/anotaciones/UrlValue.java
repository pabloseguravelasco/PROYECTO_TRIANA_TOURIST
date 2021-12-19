package com.salesianostriana.dam.TrianaTourist.validacion.anotaciones;

import com.salesianostriana.dam.TrianaTourist.validacion.validador.UrlValueValidator;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Constraint(validatedBy = UrlValueValidator.class)
@Target({ElementType.TYPE, ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
public @interface UrlValue {

    String message() default "La URL no existe";

    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};

    String coverPhoto();


    @Target({ElementType.TYPE, ElementType.FIELD})
    @Retention(RetentionPolicy.RUNTIME)
    @interface List{
        UrlValue[] value();
    }
}
