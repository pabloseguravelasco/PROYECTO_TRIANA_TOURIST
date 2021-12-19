package com.salesianostriana.dam.TrianaTourist.dto.RouteDto;

import com.salesianostriana.dam.TrianaTourist.model.POI;
import com.salesianostriana.dam.TrianaTourist.validacion.anotaciones.UniqueName;
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

    @NotNull(message = "{category.name.null}")
    @NotBlank(message = "{category.name.blank}")
    @UniqueName
    private String name;

    private List<POI> poi;

}