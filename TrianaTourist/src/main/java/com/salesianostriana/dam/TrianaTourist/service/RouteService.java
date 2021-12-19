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
        }else{
            return routeRepository.findAll();
        }
    }
    public Optional<Route> findById(Long id){
        if (routeRepository.findById(id).isEmpty()){
            throw new SingleEntityNotFoundException(Route.class, id.toString());
        }else {
            return routeRepository.findById(id);
        }
    }

    public void save(Route route){
        routeRepository.save(route);
    }

    public ResponseEntity<Route> edit(Long id, CreateRouteDto c) {

        Optional<Route> data = routeRepository.findById(id);

        if (data.isEmpty()) {
            throw new SingleEntityNotFoundException(Category.class, id.toString());
        } else {
            return ResponseEntity.of(routeRepository.findById(id).map(
                    m -> {
                        m.setName(c.getName());
                        routeRepository.save(m);
                        return m;
                    }
            ));
        }


    }

    public ResponseEntity<?> delete(Long id) {

        Optional<Route> data = routeRepository.findById(id);

        if (data.isEmpty()) {
            throw new SingleEntityNotFoundException(Category.class, id.toString());
        } else {
            routeRepository.deleteById(id);
            return ResponseEntity.status(204).build();
        }

    }
}
