package com.salesianostriana.dam.TrianaTourist.errores.excepciones;

public class SingleEntityNotFoundException extends EntityNotFoundException {

    public SingleEntityNotFoundException(Long id) {
        super(String.format("No se puede encontrar una entidad del tipo POI con ID: %s", id));
    }
}
