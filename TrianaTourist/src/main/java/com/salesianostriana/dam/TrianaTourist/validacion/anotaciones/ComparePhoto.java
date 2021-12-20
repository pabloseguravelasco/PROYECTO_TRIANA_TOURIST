package com.salesianostriana.dam.TrianaTourist.validacion.anotaciones;

import com.salesianostriana.dam.TrianaTourist.validacion.validador.ComparePhotoValidator;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

@Constraint(validatedBy = ComparePhotoValidator.class)
@Target({ ElementType.TYPE })
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface ComparePhoto {

    String message() default "Las fotos no pueden ser iguales";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};

    String coverPhoto();

    String photo2();

    String photo3();

    @Target({ElementType.TYPE})
    @Retention(RetentionPolicy.RUNTIME)
    @interface List {
        ComparePhoto[] value();


    }
}

