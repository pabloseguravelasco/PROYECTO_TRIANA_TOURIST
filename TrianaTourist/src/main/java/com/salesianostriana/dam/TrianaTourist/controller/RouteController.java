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
    public ResponseEntity<GetRouteDto> create(@Valid @RequestBody CreateRouteDto createRouteDto){
        Route route= routeDtoConverter.createRouteDtoToRoute(createRouteDto);
        routeService.save(route);
        return ResponseEntity.status(HttpStatus.CREATED).body(routeDtoConverter.routeToGetRouteDto(route));
    }

    @PostMapping("/{id}/interes/{id2}")
    public ResponseEntity<GetRouteDto> addPoi(@Valid @PathVariable("id")Long id, @PathVariable("id2")Long id2){
        Route route = routeService.findById(id).get();
        POI poi= poiService.findOne(id2).get();
        poi.addToRoute(route);
        poiService.save(poi);
        return ResponseEntity.ok().body(routeDtoConverter.routeToGetRouteDto(route));
    }

    @DeleteMapping("/{id}/interes/{id2}")
    public ResponseEntity<GetRouteDto> deletePoi(@Valid @PathVariable("id")Long id, @PathVariable("id2")Long id2){
        Route route = routeService.findById(id).get();
        POI poi= poiService.findOne(id2).get();
        poi.deleteFromRoute(route);
        poiService.save(poi);
        return ResponseEntity.ok().body(routeDtoConverter.routeToGetRouteDto(route));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Route> edit(@PathVariable("id") Long id, @Valid@RequestBody CreateRouteDto createRouteDto){
        return routeService.edit(id, createRouteDto);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteById(@PathVariable("id") Long id){
        return routeService.delete(id);
    }

}
