package com.salesianostriana.dam.TrianaTourist.repository;

import com.salesianostriana.dam.TrianaTourist.model.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<Category, Long> {

    boolean existsByName(String name);
}
