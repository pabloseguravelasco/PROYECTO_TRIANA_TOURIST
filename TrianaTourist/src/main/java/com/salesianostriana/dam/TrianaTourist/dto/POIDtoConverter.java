package com.salesianostriana.dam.TrianaTourist.dto;

import com.salesianostriana.dam.TrianaTourist.model.POI;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Component
public class POIDtoConverter {

    public POI createPOIDtoToPOI(CreatePOIDto dto){
        return POI.builder()
                .id(dto.getId())
                .name(dto.getName())
                .location(dto.getLocation())
                .description(dto.getDescription())
                .date(dto.getDate())
                .category(dto.getCategory())
                .coverPhoto(dto.getCoverPhoto())
                .photo2(dto.getPhoto2())
                .photo3(dto.getPhoto3())
                .build();
    }

    public GetPOIDto POIToGetPOIDto(POI poi){
        return GetPOIDto.builder()
                .id(poi.getId())
                .name(poi.getName())
                .marca(estacion.getMarca())
                .ubicacion(estacion.getUbicacion())
                .tieneAutolavado(estacion.isTieneAutolavado())
                .precioGasoilNormal(estacion.getPrecioGasoilNormal())
                .precioGasolina95Octanos(estacion.getPrecioGasolina95Octanos())
                .precioGasoilEspecial(estacion.getPrecioGasoilEspecial())
                .precioGasolina98(estacion.getPrecioGasolina98())
                .servicios(estacion.getServicios())
                .fechaApertura(estacion.getFechaApertura())
                .fechaRegistro(LocalDateTime.now())
                .build();



    }
}
