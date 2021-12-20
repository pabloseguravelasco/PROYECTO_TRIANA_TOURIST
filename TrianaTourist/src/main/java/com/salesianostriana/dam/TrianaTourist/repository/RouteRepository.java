package com.salesianostriana.dam.TrianaTourist.repository;

import com.salesianostriana.dam.TrianaTourist.model.Route;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RouteRepository extends JpaRepository<Route, Long> {

     boolean existsByName(String name);

}
