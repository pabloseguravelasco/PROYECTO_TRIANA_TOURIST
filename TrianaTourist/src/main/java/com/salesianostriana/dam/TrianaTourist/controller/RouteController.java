package com.salesianostriana.dam.TrianaTourist.controller;

import com.salesianostriana.dam.TrianaTourist.dto.RouteDto.CreateRouteDto;
import com.salesianostriana.dam.TrianaTourist.dto.RouteDto.GetRouteDto;
import com.salesianostriana.dam.TrianaTourist.dto.RouteDto.RouteDtoConverter;
import com.salesianostriana.dam.TrianaTourist.model.POI;
import com.salesianostriana.dam.TrianaTourist.model.Route;
import com.salesianostriana.dam.TrianaTourist.service.POIService;
import com.salesianostriana.dam.TrianaTourist.service.RouteService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@RestController
@RequiredArgsConstructor
@RequestMapping("/route")
public class RouteController {

    private final RouteService routeService;
    private final RouteDtoConverter routeDtoConverter;
    private final POIService poiService;

    @GetMapping("/")
    public ResponseEntity<List<Route>> findAll(){

        return ResponseEntity.ok().body(routeService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Optional<Route>> findOne(@PathVariable("id") Long id){

        return ResponseEntity.ok().body(routeService.findById(id));
    }

    @PostMapping("/")
    public ResponseEntity<GetRouteDto> createRoute(@Valid @RequestBody CreateRouteDto createRouteDto){

        Route route= routeDtoConverter.createRouteDtoToRoute(createRouteDto);

        routeService.saveRoute(route);

        return ResponseEntity.status(HttpStatus.CREATED).body(routeDtoConverter.routeToGetRouteDto(route));
    }

    @PostMapping("/{id}/add/{id2}")
    public ResponseEntity<GetRouteDto> addPOItoRoute(@Valid @PathVariable("id")Long id, @PathVariable("id2")Long id2){

        Route route = routeService.findById(id).get();
        POI poi= poiService.findOne(id2).get();

        poi.addToRoute(route);
        poiService.savePOI(poi);

        return ResponseEntity.ok().body(routeDtoConverter.routeToGetRouteDto(route));
    }

    @DeleteMapping("/{id}/delete/{id2}")
    public ResponseEntity<GetRouteDto> deletePOI(@Valid @PathVariable("id")Long id, @PathVariable("id2")Long id2){

        Route route = routeService.findById(id).get();
        POI poi= poiService.findOne(id2).get();

        poi.deleteFromRoute(route);
        poiService.savePOI(poi);

        return ResponseEntity.ok().body(routeDtoConverter.routeToGetRouteDto(route));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Route> edit(@PathVariable("id") Long id, @Valid@RequestBody CreateRouteDto createRouteDto){

        return routeService.editRoute(id, createRouteDto);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteById(@PathVariable("id") Long id){

        return routeService.deleteRoute(id);
    }

}
