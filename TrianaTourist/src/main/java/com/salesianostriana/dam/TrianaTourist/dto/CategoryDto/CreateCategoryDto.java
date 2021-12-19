package com.salesianostriana.dam.TrianaTourist.dto.CategoryDto;

import com.salesianostriana.dam.TrianaTourist.validacion.anotaciones.UniqueName;
import lombok.*;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;


@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
public class CreateCategoryDto {

    private Long id;

    @NotNull(message = "{category.name.null}")
    @NotBlank(message = "{category.name.blank}")
    @UniqueName
    private String name;
}
