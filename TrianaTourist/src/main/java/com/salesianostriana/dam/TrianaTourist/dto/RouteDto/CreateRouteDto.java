package com.salesianostriana.dam.TrianaTourist.dto.RouteDto;

import com.salesianostriana.dam.TrianaTourist.model.POI;
import com.salesianostriana.dam.TrianaTourist.validacion.anotaciones.UniqueName;
import com.salesianostriana.dam.TrianaTourist.validacion.anotaciones.UniqueNameRoute;
import lombok.*;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CreateRouteDto {

    private Long id;

    @NotNull(message = "{Route.name.null}")
    @NotBlank(message = "{Route.name.blank}")
    @UniqueNameRoute
    private String name;

    private List<POI> steps;

}