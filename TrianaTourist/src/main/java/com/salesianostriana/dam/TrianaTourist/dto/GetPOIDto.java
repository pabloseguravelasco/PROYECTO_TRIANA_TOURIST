package com.salesianostriana.dam.TrianaTourist.dto;


import com.salesianostriana.dam.TrianaTourist.model.Category;
import com.salesianostriana.dam.TrianaTourist.model.Route;
import lombok.*;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@Setter
public class GetPOIDto {


    private Long id;
    private String name;
    private String nameCategory;
    private String coverPhoto;
    private String nameRoute;
}
