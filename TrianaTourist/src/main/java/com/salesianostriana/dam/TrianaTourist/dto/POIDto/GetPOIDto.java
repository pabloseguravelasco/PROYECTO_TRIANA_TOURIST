package com.salesianostriana.dam.TrianaTourist.dto.POIDto;


import com.salesianostriana.dam.TrianaTourist.model.Category;
import com.salesianostriana.dam.TrianaTourist.model.Route;
import lombok.*;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;
import java.util.Date;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@Setter
public class GetPOIDto {


    private Long id;
    private String name;
    private String location;
    private Date date;
    private Category category;
    private String coverPhoto;
    private String photo2;
    private String photo3;

}
