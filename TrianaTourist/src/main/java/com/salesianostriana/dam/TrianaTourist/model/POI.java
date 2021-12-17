package com.salesianostriana.dam.TrianaTourist.model;

import lombok.*;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
public class POI {

    @Id
    @GeneratedValue
    private Long id;

    @NotNull(message = "POI.name.null")
    @NotBlank(message = "POI.name.blank")
    private String name;

    @NotNull(message = "{POI.location.null}")
    @NotBlank(message = "{POI.location.blank}")
    private String location;

    @Lob
    private String description;


    @DateTimeFormat
    private LocalDateTime date;

    @NotNull(message = "POI.category.null")
    @NotBlank(message = "POI.category.blank")
    private Category category;

    @NotNull(message = "POI.coverPhoto.null")
    @NotBlank(message = "POI.coverPhoto.blank")
    private String coverPhoto;

    private String photo2;
    private String photo3;


}
