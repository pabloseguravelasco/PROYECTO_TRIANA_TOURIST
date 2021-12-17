package com.salesianostriana.dam.TrianaTourist.repository;

import com.salesianostriana.dam.TrianaTourist.model.POI;
import org.springframework.data.jpa.repository.JpaRepository;

public interface POIRepository extends JpaRepository<POI, Long> {

    boolean existsByName(String name);
}
