package com.salesianostriana.dam.TrianaTourist.service;


import com.salesianostriana.dam.TrianaTourist.dto.RouteDto.CreateRouteDto;
import com.salesianostriana.dam.TrianaTourist.errores.excepciones.ListEntityNotFoundException;
import com.salesianostriana.dam.TrianaTourist.errores.excepciones.SingleEntityNotFoundException;
import com.salesianostriana.dam.TrianaTourist.model.Category;
import com.salesianostriana.dam.TrianaTourist.model.Route;
import com.salesianostriana.dam.TrianaTourist.repository.RouteRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class RouteService {

    private final RouteRepository routeRepository;

    public List<Route> findAll(){
        if (routeRepository.findAll().isEmpty()){
            throw new ListEntityNotFoundException(Route.class);
        }
            return routeRepository.findAll();

    }
    public Optional<Route> findById(Long id){
        if (routeRepository.findById(id).isEmpty()){
            throw new SingleEntityNotFoundException(Route.class, id.toString());
        }
            return routeRepository.findById(id);

    }

    public void saveRoute(Route route){

        routeRepository.save(route);
    }

    public ResponseEntity<Route> editRoute(Long id, CreateRouteDto dto) {

        Optional<Route> data = routeRepository.findById(id);

        if (data.isEmpty()) {
            throw new SingleEntityNotFoundException(Category.class, id.toString());
        }
            return ResponseEntity.of(routeRepository.findById(id).map(
                    x -> {
                        x.setName(dto.getName());
                        routeRepository.save(x);
                        return x;
                    }
            ));
        }


    public ResponseEntity<?> deleteRoute(Long id) {

        Optional<Route> data = routeRepository.findById(id);

        if (data.isEmpty()) {
            throw new SingleEntityNotFoundException(Category.class, id.toString());
        } else {
            routeRepository.deleteById(id);
            return ResponseEntity.status(204).build();
        }

    }
}
