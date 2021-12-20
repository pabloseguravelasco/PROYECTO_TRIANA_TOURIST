package com.salesianostriana.dam.TrianaTourist.dto.POIDto;


import com.salesianostriana.dam.TrianaTourist.validacion.anotaciones.ComparePhoto;
import com.salesianostriana.dam.TrianaTourist.validacion.anotaciones.ExistLocation;
import com.salesianostriana.dam.TrianaTourist.validacion.anotaciones.UniqueName;
import com.salesianostriana.dam.TrianaTourist.validacion.anotaciones.UniqueNamePOI;
import lombok.*;
import org.hibernate.validator.constraints.URL;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.Date;


@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
@ComparePhoto(coverPhoto = "coverPhoto", photo2 = "photo2", photo3 = "photo3")
@ExistLocation.List({
        @ExistLocation(
                location = "location"
        )
})
public class CreatePOIDto {


    @Id
    @GeneratedValue
    private Long id;

    @NotNull(message = "POI.name.null")
    @NotBlank(message = "POI.name.blank")
    @UniqueNamePOI
    private String name;

    @NotNull(message = "{POI.location.null}")
    private String location;

    @Lob
    private String description;



    private Date date;

    @NotNull(message = "POI.category.null")
    private Long category;

    @URL
    @NotNull(message = "POI.coverPhoto.null")
    private String coverPhoto;

    private String photo2;
    private String photo3;
}
