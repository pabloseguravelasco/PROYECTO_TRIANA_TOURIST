package com.salesianostriana.dam.TrianaTourist.validacion.validador;

import com.salesianostriana.dam.TrianaTourist.validacion.anotaciones.ComparePhoto;
import org.springframework.beans.PropertyAccessorFactory;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class ComparePhotoValidator implements ConstraintValidator<ComparePhoto, Object> {

    private String coverPhoto;
    private String photo2;
    private String photo3;

    @Override
    public void initialize(ComparePhoto constraintAnnotation) {
        this.coverPhoto = constraintAnnotation.coverPhoto();
        this.photo2 = constraintAnnotation.photo2();
        this.photo3 = constraintAnnotation.photo3();

    }

    @Override
    public boolean isValid(Object value, ConstraintValidatorContext context) {

        Object coverPhotoValue = PropertyAccessorFactory.forBeanPropertyAccess(value).getPropertyValue(coverPhoto);
        Object photoValue = PropertyAccessorFactory.forBeanPropertyAccess(value).getPropertyValue(photo2);
        Object photoValueMatch = PropertyAccessorFactory.forBeanPropertyAccess(value).getPropertyValue(photo3);

        if (coverPhotoValue != null) {
            return !coverPhotoValue.equals(photoValue) && !coverPhotoValue.equals(photoValueMatch) && !photoValue.equals(photoValueMatch);
        } else {
            return coverPhotoValue == null;
        }
    }
}


