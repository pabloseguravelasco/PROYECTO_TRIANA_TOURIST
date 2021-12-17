package com.salesianostriana.dam.TrianaTourist.model;


import lombok.*;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.List;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
public class Route {

    @Id
    @GeneratedValue
    private Long id;

    private String name;
    private List<POI> steps;
}
