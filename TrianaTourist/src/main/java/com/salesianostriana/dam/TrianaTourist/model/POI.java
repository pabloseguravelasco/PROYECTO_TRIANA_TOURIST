package com.salesianostriana.dam.TrianaTourist.model;

import lombok.*;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;
import java.util.Date;

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


    private String name;
    private String location;
    private String description;
    private Date date;


    @ManyToOne
    @JoinColumn(name = "category_id", foreignKey = @ForeignKey( name = "FK_POI_CATEGORY"))
    private Category category;

    private String coverPhoto;
    private String photo2;
    private String photo3;

    //Métodos HELPER

    public void addToRoute(Route route){
        route.getSteps().add(this);
    }
    public void deleteFromRoute(Route route){
        route.getSteps().remove(this);
    }


}
