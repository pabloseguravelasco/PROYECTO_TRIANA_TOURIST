package com.salesianostriana.dam.TrianaTourist.validacion.anotaciones;

import com.salesianostriana.dam.TrianaTourist.validacion.validador.ExistLocationValidator;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;


@Constraint(validatedBy = ExistLocationValidator.class)
@Target({ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
public @interface ExistLocation {

    String message() default "Las coordenadas no existen";

    Class<?>[] groups() default {};
    Class<? extends Payload> [] payload() default {};

    String location();

    @Target({ElementType.TYPE})
    @Retention(RetentionPolicy.RUNTIME)
    @interface List{
        ExistLocation[] value();
    }
}
