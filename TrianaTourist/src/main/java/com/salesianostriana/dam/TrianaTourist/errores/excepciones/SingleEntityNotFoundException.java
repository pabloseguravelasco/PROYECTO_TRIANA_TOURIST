package com.salesianostriana.dam.TrianaTourist.errores.excepciones;

public class SingleEntityNotFoundException extends EntityNotFoundException {

    public SingleEntityNotFoundException(Class clazz, String id) {
        super(String.format("No se puede encontrar una entidad del tipo %s con ID: %s",id, clazz.getName() ));
    }
}
