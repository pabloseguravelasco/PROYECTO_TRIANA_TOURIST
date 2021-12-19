package com.salesianostriana.dam.TrianaTourist.dto.RouteDto;

import com.salesianostriana.dam.TrianaTourist.model.Route;
import com.salesianostriana.dam.TrianaTourist.repository.POIRepository;
import com.salesianostriana.dam.TrianaTourist.service.POIService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class RouteDtoConverter {

    private final POIService poiService;
    private final POIRepository poiRepository;

    public GetRouteDto routeToGetRouteDto (Route r){
        return GetRouteDto.builder()
                .id(r.getId())
                .name(r.getName())
                .steps(r.getSteps())
                .build();
    }

    public Route createRouteDtoToRoute (CreateRouteDto r){
        return Route.builder()
                .name(r.getName())
                .steps(r.getPoi())
                .build();
    }

}
