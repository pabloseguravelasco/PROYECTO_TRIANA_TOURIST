package com.salesianostriana.dam.TrianaTourist.dto.RouteDto;

import com.salesianostriana.dam.TrianaTourist.model.POI;
import lombok.*;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class GetRouteDto {

    private Long id;
    private String name;
    private List<POI> steps;

}
